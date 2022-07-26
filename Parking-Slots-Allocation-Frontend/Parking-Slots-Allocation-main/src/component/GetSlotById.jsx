import React,{useState,useEffect} from 'react'
import axios from 'axios'
import Loginuserinfo from "../component/Loginuserinfo";
import {Link} from "react-router-dom";

export function GetSlotById() {
  
   const[parkingId,setParkingId] = useState()
   const[parkingslot,setParkingSlot]=useState()
   const[idFromBtn,setIdFromBtn]=useState()

   useEffect(()=>
   {
     axios.get(`http://localhost:8087/parkingslot/findbyid/${parkingId}`)
     .then(response=>{
         console.log(response.data)
         setParkingSlot(response.data)
     })
     .catch(error=>console.log(error))
   },[idFromBtn]
   )
        
     return (
            <div style={{background:"#BBDAF6"}} className="container mt-3">
              <Link to={'/menuA'} className="btn btn-primary mt-2">Go back</Link>
             <h2>Get Slot By Id</h2>
             <hr />
             <div className="form-group">
                 <label> Parking Slot Id</label>
                 <input value={parkingId} onChange={(event) => setParkingId(event.target.value)} className="form-control" required />
             </div>
             <button onClick={() => setIdFromBtn(parkingId)} className="m-2 btn-primary">Search</button>
             <hr />
             {parkingslot && <div>
                 <h3>Parking Slot Id: {parkingId} Details</h3>
                 <ul className="list-group">
                     <li className="list-group-item list-group-item-success">Parking Slot Id: {parkingslot.parkingSlotId}</li>
                     <li className="list-group-item list-group-item-success">Parking Date: {parkingslot.parkingDate}</li>
                     <li className="list-group-item list-group-item-success">Parking Time: {parkingslot.parkingTime}</li>
                     <li className="list-group-item list-group-item-success">Parking Duration: {parkingslot.parkingDuration}</li>
                     <li className="list-group-item list-group-item-success">Parking Premise Id: {parkingslot.parkingPremise.parkingPremiseId}</li>
                     <li className="list-group-item list-group-item-success">Parking Premise Name: {parkingslot.parkingPremise.parkingPremiseName}</li>
                     <li className="list-group-item list-group-item-success">Parking Floor: {parkingslot.parkingPremise.numberOfParkingFloors}</li>
                     <li className="list-group-item list-group-item-success">City: {parkingslot.parkingPremise.addressId.city}</li>
                     <li className="list-group-item list-group-item-success">State: {parkingslot.parkingPremise.addressId.state}</li>
                     <li className="list-group-item list-group-item-success">Pin Code: {parkingslot.parkingPremise.addressId.pin}</li>

                 </ul>
             </div>}
         </div>
    )}
         