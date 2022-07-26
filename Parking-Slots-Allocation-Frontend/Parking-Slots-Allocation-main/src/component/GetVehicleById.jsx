import React,{useState,useEffect} from 'react'
import axios from 'axios'
import { useParams,Link} from 'react-router-dom';
import "./styles.css";

import Loginuserinfo from "../component/Loginuserinfo";
export function GetVehicleById() {
    const[vehicleId,setVehicleId] = useState()
    const [vehicle, setVehicle] = useState();
    const[idFromBtn,setIdFromBtn]=useState()
    const { idFrom } = useParams();
    // const navigate = useNavigate();
   

    const handleSubmit=() => {
        axios.get(`http://localhost:8087/vehicle/fetchvehiclebyid/${vehicleId}`).then(resp =>{
             setVehicle(resp.data)
    })
    .catch(error=>alert("Enter the valid Vehicle ID"))
    }
    



return (<><Loginuserinfo /><div className='middle container'>
    <h3 className="main-text-info">Get Vehicle</h3>
    <hr />
    <div className="form-group">
        <label className="main-text-info">Enter The Vehicle ID</label>
        <input value={vehicleId} onChange={(event) => setVehicleId(event.target.value)} className="form-control" required />

    </div>
    <button className='btn btn-primary' onClick={handleSubmit}>Submit</button>
    <hr />
    {vehicle && <div>
        <h3>Vehicle ID: {vehicleId}</h3>
        <ul className="list-group">
            <li className="list-group-item list-group-item-success"> Vehicle Company: {vehicle.vehicleCompany}</li>
            <li className="list-group-item list-group-item-success">Vehicle Id: {vehicle.vehicleId}</li>
            <li className="list-group-item list-group-item-success">Vehicle Model: {vehicle.vehicleModel}</li>
            <li className="list-group-item list-group-item-success">Vehicle Number: {vehicle.vehicleNumber}</li>
            <li className="list-group-item list-group-item-success">Vehicle Type: {vehicle.vehicleType}</li>
        </ul>
        <Link to="/deleteVehicleByVehicleNumber" className="btn btn-dark">Delete Vehicle</Link>
    </div>}
</div></>


)

}
         