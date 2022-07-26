import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams,useNavigate} from 'react-router-dom';
import "./styles.css";
import Loginuserinfo from "../component/Loginuserinfo";

 function  UpdateVehicle() {

    const [vId, setVId] = useState('');
    const [vCompany, setVCompany] = useState('');
    const [vModel, setVModel] = useState('');
    const [vNumber, setVNumber] = useState('');
    const [vType, setVtype] = useState('');
    
    const { id } = useParams();
    const navigate = useNavigate();
    
    useEffect(() => {
        axios.get("http://localhost:8087/vehicle/fetchvehiclebyid/"+id).then(resp => {
            setVId(resp.data.vehicleId);
            setVCompany(resp.data.vehicleCompany);
            setVModel(resp.data.vehicleModel);
            
            setVNumber(resp.data.vehicleNumber);
            setVtype(resp.data.vehicleType);
        });
    }, [id])

    const handleSubmit = () => {
        const payload = {
            vehicleId: vId,
            vehicleCompany: vCompany,
            vehicleModel: vModel,
            vehicleNumber: vNumber,
            vehicleType:vType
            
        }

        axios.put("http://localhost:8087/vehicle/update/"+id,payload)
        .then(resp=>{
            alert("vehicle is Updated with id :" +resp.data.vehicleId);
            navigate('/viewAllVehicle');
    })
        
        .catch(error=>alert("something went wrong"))
    }
 
    
 
        return(
            <><Loginuserinfo /><div className="middle container">
                <h2 className="main-text-info">Update Vehicle </h2>
                <label>Vehicle Id</label>
                <div className="form-group">
                    <input type="text" id="vId" className="form-control" name="vId" value={vId} disabled required></input>
                </div>
                <div className="form-group">
                    <label>Vehicle Company</label>
                    <input type="text" id="vCompany" required className="form-control" name="vCompany" value={vCompany} onChange={e => setVCompany(e.target.value)}></input>
                </div>
                <div className="form-group">
                    <label>Vehicle Model</label>
                    <input type="text" id="vModel" className="form-control" required name="vModel" value={vModel} onChange={e => setVModel(e.target.value)}></input>
                </div>
                <div className="form-group">
                    <label>Vehicle Number</label>
                    <input type="text" id="vNumber" className="form-control" required name="vNumber" value={vNumber} onChange={e => setVNumber(e.target.value)}></input>
                </div>


                {/*
        <label>Vehicle Type</label>
        <input type="text" id="vType" className="form-control" name="vType" value={vType} onChange={e => setVtype(e.target.value)}></input>
    </div> */}
                <label> Vehicle Type </label>
                <div className="form-group">

                    <select defaultValue={vType}
                        onChange={e => setVtype(e.target.value)}
                    ><option value="Select">Select</option>
                        <option value="TWO_WHEELER">Two Wheeler</option>
                        <option value="THREE_WHEELER">Three Wheeler</option>
                        <option value="FOUR_WHEELER">Four Wheeler</option>
                    </select>

                </div>


                <div>
                    <button className="btn" onClick={handleSubmit}>Submit</button>
                </div>
            </div></>
       
    )
}

export default UpdateVehicle;