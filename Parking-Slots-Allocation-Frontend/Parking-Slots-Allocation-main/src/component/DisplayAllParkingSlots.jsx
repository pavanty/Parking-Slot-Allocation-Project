import axios from 'axios'
import React ,{useEffect,useState} from 'react'
import Loginuserinfo from "../component/Loginuserinfo";
import {Link} from "react-router-dom";

export  function DisplayAllParkingSlots() {
  
    const[parkingslot,setParkingSlot]=useState([])

    useEffect(()=>
    {
        axios.get("http://localhost:8087/parkingslot/allps")
             .then(response=>{
                 console.log(response.data)
                 setParkingSlot(response.data)
             })
         .catch(error=>console.log(error))
        },[]) 


     return(
        
            <div style={{background:"#BBDAF6"}} className="container mt-3">
              <Link to={'/menuA'} className="btn btn-primary mt-2">Go back</Link>
             <h2>Display All Parking Slot</h2>
             <hr />
             <table className="table table-bordered table-hover table-striped">
                 <thead>
                     <tr>
                         <th>parkingSlot</th>
                         <th>parkingDate</th>
                         <th>parkingTime</th>
                         <th>parkingDuration</th>
                         <th>parkingPremiseName</th>
                         <th>ParkingFloor</th>
                         <th>city</th>
                         <th>state</th>
                         <th>pin</th>
                     </tr>
                 </thead>
                 <tbody>
                     {parkingslot.map(parkingslot => (
                         <tr key={parkingslot.parkingSlotId}>

                             <td>{parkingslot.parkingSlotId}</td>
                             <td>{parkingslot.parkingDate}</td>
                             <td>{parkingslot.parkingTime}</td>
                             <td>{parkingslot.parkingDuration}</td>

                             <td>{parkingslot.parkingPremise.parkingPremiseName}</td>
                             <td>{parkingslot.parkingPremise.numberOfParkingFloors}</td>

                             <td>{parkingslot.parkingPremise.addressId.city}</td>
                             <td>{parkingslot.parkingPremise.addressId.state}</td>
                             <td>{parkingslot.parkingPremise.addressId.pin}</td>

                         </tr>

                     ))}
                 </tbody>
             </table>
         </div>
     )
 }
