
import React, { useState} from 'react';
// import VehicleService from "./services/VehicleService";
import axios from 'axios';
import Loginuserinfo from "../component/Loginuserinfo";
import "./styles.css";
import { Link,useNavigate} from 'react-router-dom';

function AddVehicle(){
    const [validated, setValidated] = useState(false);
const [vusersid, setUsersid] = useState('');
const[vcompany,setVCompany]= useState('');
const[vmodel,setVModel]= useState('');
const[vnumber,setVNumber]= useState('');
const[vtype,setVType]= useState('');
const navigate = useNavigate();
const handleSubmit=()=>{

    const payload={
        user_id:vusersid,
        vehicleCompany:vcompany,
       
        vehicleModel:vmodel,
        vehicleNumber:vnumber,
        vehicleType:vtype,
    }

    axios.post("http://localhost:8087/vehicle/addvehicle?user_id="+vusersid,payload)
    .then(resp=>{
        alert("vehicle is saved with id :" +resp.data.vehicleId);
        navigate('/Book-Parking-Slot')
    })
       
    .catch(error=>alert("Enter The Valid Vehicle Details"))
}



return (
   
    <>< Loginuserinfo />
    
    
    <div className=" middle containerm">
    <h2 className="main-text-info">Add Vehicle</h2>
    <hr />
    <div className="form-group">
        <label className='variable'>User ID</label>
        <input type="text" id="vusersid" name="vusersid" className="form-control" value={vusersid} onChange={e => setUsersid(e.target.value)} required></input>
    </div>
    <div className="form-group">
        <label className='variable'>VehicleCompany</label>
        <input type="text" id="vcompany" name="vcompany" className="form-control" value={vcompany} onChange={e => setVCompany(e.target.value)} required></input>
    </div>
    <div className="form-group">
        <label className='variable'>Vehicle Model</label>
        <input type="text" id="vmodel" name="vmodel" className="form-control" value={vmodel} onChange={e => setVModel(e.target.value)} required></input>

    </div>
    <div className="form-group">
        <label className='variable'>Vehicle Number</label>
        <input type="text" id="vvnumber" name="vnumber" className="form-control" value={vnumber} onChange={e => setVNumber(e.target.value)} required></input>
    </div>


    <label className='variable'> Vehicle Type </label>

    <div className="form-group">

        <select defaultValue={vtype}
            onChange={e => setVType(e.target.value)}
        ><option  dropdown-item value="Select">Select</option>
            <option   value="TWO_WHEELER">Two Wheeler</option>
            <option  value="THREE_WHEELER">Three Wheeler</option>
            <option  value="FOUR_WHEELER">Four Wheeler</option>
        </select>

    </div>






    <div>
        <button className='btn btn-primary' onClick={handleSubmit}>Submit</button>
        <Link to="/ViewAllVehicle" className="btn btn-dark">View Vehicles</Link>
    </div>


</div></>

)
}

export default AddVehicle;


