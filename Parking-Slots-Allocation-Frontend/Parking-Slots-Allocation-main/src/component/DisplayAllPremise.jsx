import axios from 'axios'
import React ,{useEffect,useState} from 'react'
import Admindashboardinfo from "../component/Admindashboardinfo";

export  function DisplayAllPremise() {
  
    const[premise,setPremise]=useState([])

    useEffect(()=>
    {
        axios.get("http://localhost:8087/admin/getallPremise")
             .then(response=>{
                 console.log(response.data)
                 setPremise(response.data)
             })
         .catch(error=>console.log(error))
        },[]) 


     return(
        <><Admindashboardinfo /><div style={{background:"#BBDAF6"}} className="container mt-3">
             <h2 className="text-info">Display All Premise</h2>
             <hr />
             <table className="table table-bordered table-hover table-striped">
                 <thead>
                     <tr>
                         <th>parkingPremiseName</th>
                         <th>ParkingFloor</th>
                         <th>city</th>
                         <th>state</th>
                         <th>pin</th>
                     </tr>
                 </thead>
                 <tbody>
                     {premise.map(premise => (
                         <tr key={premise.parkingPremiseId}>

                             <td>{premise.parkingPremiseName}</td>
                             <td>{premise.numberOfParkingFloors}</td>

                             <td>{premise.addressId.city}</td>
                             <td>{premise.addressId.state}</td>
                             <td>{premise.addressId.pin}</td>

                         </tr>

                     ))}
                 </tbody>
             </table>
         </div></>
     )
 }
