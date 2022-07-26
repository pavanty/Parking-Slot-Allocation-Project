import axios from 'axios'
import React ,{useEffect,useState} from 'react'
import {Link } from 'react-router-dom';
import Admindashboardinfo from "../component/Admindashboardinfo";
import "./styles.css";


export  function ViewAllVehicle() {
  
    const[vehicle,setVehicle]=useState([])



    useEffect(()=>
    {
        axios.get('http://localhost:8087/vehicle/getallvehicles')
             .then(response=>{
                 console.log(response.data)
                 setVehicle(response.data)
             })
         .catch(error=>console.log(error))
        },[]) 
     

     return(
        <><Admindashboardinfo /><div className="viewvehicle container-m2">
             <h2 className="main-text-info">View All Vehicle</h2>
             <hr />
             <table className="table addvehicle table-bordered  thead-dark">
                 <thead>
                     <tr>
                         
                         <th>Vehicle ID</th>
                         <th>Vehicle Company</th>
                         <th>Vehicle Model</th>
                         <th>Vehicle Number</th>
                         <th>Vehicle Type</th>
                         <th>Edit Vehicle</th>
                         

                     </tr>
                 </thead>
                 <tbody>
                     {vehicle.map(vehicle => (
                         <tr key={vehicle.vehicleId}>
  <td>{vehicle.vehicleId}</td>
                             <td>{vehicle.vehicleCompany}</td>
                           
                             <td>{vehicle.vehicleModel}</td>
                             <td>{vehicle.vehicleNumber}</td>
                             <td>{vehicle.vehicleType}</td>
                           <Link to ={`/updateVehicle/${vehicle.vehicleId}`} className="btn btn btn-primary bg-primary">Edit Vehicle</Link>
                          


                         </tr>

                     ))}
                 </tbody>
             </table>
         </div></>
     )
 }