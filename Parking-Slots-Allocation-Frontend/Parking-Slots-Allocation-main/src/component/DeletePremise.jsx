import React,{useState,useEffect} from 'react'
import axios from 'axios'
import Admindashboardinfo from "../component/Admindashboardinfo";

export function DeletePremise() {
  
   const[premiseId,setPremiseId] = useState()
   const[premise,setPremise]=useState()
   const[FromBtn,setFromBtn]=useState()

   useEffect(()=>
   {
     axios.delete(`http://localhost:8087/admin/removePremise/${premiseId}`)
     .then(response=>{
         console.log(response.data)
         setPremise(response.data)
     })
     .catch(error=>console.log(error))
   },[FromBtn, premiseId]
   )
        
     return (
      <><Admindashboardinfo /><div style={{background:"#BBDAF6"}} className="container mt-3">
         <h2>Delete Premise By Id</h2>
         <hr />
         <div className="form-group">
           <label>Enter Premise Id: </label>
           <input value={premiseId} onChange={(event) => setPremiseId(event.target.value)} className="form-control" required />
         </div>
         <button onClick={() => setFromBtn(premiseId)} className="m-2 btn-primary">Delete</button>
         <hr />
         {premise && <div>
           <h3>Premise Slot Id: {premiseId} Deleted</h3>
         </div>}
       </div></>)}