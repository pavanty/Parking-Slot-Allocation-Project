import axios from "axios";
import React, { useState, useEffect } from "react";
import {useNavigate,Link} from 'react-router-dom';

import Loginuserinfo from "../component/Loginuserinfo";
import "./styles.css";
export function DeleteVehicleByVehicleNumber() {
  const [vehicleNumber, setVehicleNumber] = useState();
  const [vehicle, setVehicle] = useState();
  // const [idFromBtn, setIdFromBtn] = useState();
  const navigate = useNavigate();
  const handleSubmit=() => {
    axios
      .delete(`http://localhost:8087/vehicle/deletevehicle/${vehicleNumber}`)
      .then(response => {
        console.log(response.data);
        setVehicle(response.data);
        // alert("vehilce deleted");
        // navigate("/viewAllVehicle")
      
       
      }).catch(error=>alert("Vehicle Number Not Found"))

      
  }
  // ,[idFromBtn]
 
  // )

  return (

    <><Loginuserinfo />
  
    <div className=" middle container">
          <h3 className="main-text-info">Delete Vehicle</h3>
          <hr />
          <div className="form-group">
              <label >Vehicle Number</label>
              <input value={vehicleNumber} onChange={(event) => setVehicleNumber(event.target.value)} className="form-control" placeholder="Enter the Vehicle Number" required />
      
          </div>
          <button className='btn btn-primary' onClick={handleSubmit}>Submit</button>
          {/* <button onClick={() => setIdFromBtn(vehicleNumber)} className="btn btn-primary m-2">Delete</button> */}
          <hr />
          
          {vehicle && <div>
          
              <h3 className="alert alert-success mt-2">Vehicle ID: {vehicleNumber} Deleted</h3>
              <Link to="/ViewAllVehicle" className="btn btn-dark">View Vehicles</Link>
         
           
          </div>}


      </div>
    
      
      </>
      
  )
}
