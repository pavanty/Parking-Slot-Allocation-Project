import axios from 'axios'
    import React , {useState,useEffect} from 'react'
    import Loginuserinfo from "../component/Loginuserinfo";
    import { Link } from 'react-router-dom';
    import "./styles.css";
    export  function ViewVehicleByVehicleNumber(){
    
        const[vehicleNumber,setVehicleNumber]=useState()
        const[vehicle,setVehicle]=useState({})
        const[idFromBtn,setIdFromBtn]=useState()

       
        const handleSubmit=() => {
        
            axios.get(`http://localhost:8087/vehicle/${vehicleNumber}`)
            .then(response=>
            
                   
                    setVehicle(response.data)
                ).catch(error=>alert("Vehicle Number Not Found"))
               
        }
        
    
        return(
            <><Loginuserinfo /><div className='middle container'>
                <h3 className="main-text-info">Get Vehicle</h3>
                
                <div className="form-group">
                    <label>Enter The Vehicle Number</label>
                    <input value={vehicleNumber} onChange={(event) => setVehicleNumber(event.target.value)} className="form-control" required />

                </div>
                <button className='btn btn-primary' onClick={handleSubmit}>Submit</button>
                <hr />
                {
                vehicle && <div>
                    <h3>Vehicle Number: {vehicleNumber}</h3>
                    <ul className="list-group">
                        <li className="list-group-item list-group-item-success"> Vehicle Company: {vehicle.vehicleCompany}</li>
                        <li className="list-group-item list-group-item-success">Vehicle Id: {vehicle.vehicleId}</li>
                        <li className="list-group-item list-group-item-success">Vehicle Model: {vehicle.vehicleModel}</li>
                        <li className="list-group-item list-group-item-success">Vehicle Number: {vehicle.vehicleNumber}</li>
                        <li className="list-group-item list-group-item-success">Vehicle Type: {vehicle.vehicleType}</li>
                        {/* <Link to={`/vehicle/edit/${vehicle.vehicleId}`}className="btn btn-dark">Edit</Link> */}
                    </ul>
                </div>}
            </div></>
        )
    }