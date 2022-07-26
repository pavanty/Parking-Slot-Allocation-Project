import React,{useState,useEffect} from 'react'
import axios from 'axios'
import Loginuserinfo from "../component/Loginuserinfo";
import {Link} from "react-router-dom";

export function CancelSlot() {
  
   const[slotId,setslotId] = useState()
   const[parkingslot,setParkingSlot]=useState()
   const[idFromBtn,setIdFromBtn]=useState()

   useEffect(()=>
   {
     axios.delete(`http://localhost:8087/parkingslot/delete/${slotId}`)
     .then(response=>{
         console.log(response.data)
         setParkingSlot(response.data)
     })
     .catch(error=>console.log(error))
   },[idFromBtn]
   )
        
     return (
      
        <div style={{background:"#BBDAF6"}} className="container mt-3">
              <Link to={'/menu'} className="btn btn-primary mt-2">Go back</Link>
         <h2>Cancel Slot By Id</h2>
         <hr />
         <div className="form-group">
           <label>Enter Parking Slot Id: </label>
           <input value={slotId} onChange={(event) => setslotId(event.target.value)} className="form-control" required />
         </div>
         <button onClick={() => setIdFromBtn(slotId)} className="m-2 btn-primary">cancel</button>
         <hr />
         {parkingslot && <div>
           <h3>Parking Slot Id: {slotId} Deleted</h3>
         </div>}
       </div>)}