import React,{useState,useEffect} from 'react'
import axios from 'axios'
import Admindashboardinfo from "../component/Admindashboardinfo";


export function GetPremiseById() {
  
   const[premiseId,setPremiseId] = useState()
   const[premise,setPremise]=useState()
   const[idFromBtn,setIdFromBtn]=useState()

   useEffect(()=>
   {
     axios.get(`http://localhost:8087/admin/getPremiseById/${premiseId}`)
     .then(response=>{
         console.log(response.data)
         setPremise(response.data)
     })
     .catch(error=>console.log(error))
   },[idFromBtn]
   )
        
     return (
        <><Admindashboardinfo /><div style={{background:"#BBDAF6"}} className="container mt-3">
             <h2>Get Premise By Id</h2>
             <hr />
             <div className="form-group">
                 <label> Premise Id</label>
                 <input value={premiseId} onChange={(event) => setPremiseId(event.target.value)} className="form-control" required />
             </div>
             <button onClick={() => setIdFromBtn(premiseId)} className="m-2 btn-primary">Search</button>
             <hr />
             {premise && <div>
                 <h3>Premise Id: {premiseId} Details</h3>
                 <ul className="list-group">
                     
                     <li className="list-group-item list-group-item-success">Parking Premise Id: {premise.parkingPremiseId}</li>
                     <li className="list-group-item list-group-item-success">Parking Premise Name: {premise.parkingPremiseName}</li>
                     <li className="list-group-item list-group-item-success">Parking Floor: {premise.numberOfParkingFloors}</li>
                     <li className="list-group-item list-group-item-success">City: {premise.addressId.city}</li>
                     <li className="list-group-item list-group-item-success">State: {premise.addressId.state}</li>
                     <li className="list-group-item list-group-item-success">Pin Code: {premise.addressId.pin}</li>

                 </ul>
             </div>}
         </div></>
    )}