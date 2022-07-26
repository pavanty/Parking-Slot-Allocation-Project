import axios from 'axios'
import React ,{useEffect,useState} from 'react'
import Loginuserinfo from "../component/Loginuserinfo";
import {Link} from "react-router-dom";

export  function AllUsers() {
  
    const[user,setUser]=useState([])

    useEffect(()=>
    {
        axios.get("http://localhost:8087/user/showAllUsers")
             .then(response=>{
                 console.log(response.data)
                 setUser(response.data)
             })
         .catch(error=>console.log(error))
        },[]) 


     return(
        
            <div style={{background:"#BBDAF6"}} className="container mt-3">
              <Link to={'/menuA'} className="btn btn-primary mt-2">Go back</Link>
             <h2>Display All Users</h2>
             <hr />
             <table className="table table-bordered table-hover table-striped">
                 <thead>
                     <tr>
                         <th>User_ID</th>
                         <th>User_Name</th>
                         <th>User_Email</th>
                         <th>User_Mobile</th>
                     </tr>
                 </thead>
                 <tbody>
                     {user.map(user => (
                         <tr key={user.user_id}>

                             <td>{user.user_id}</td>
                             <td>{user.username}</td>
                             <td>{user.email}</td>
                             <td>{user.mobile}</td>
                         </tr>

                     ))}
                 </tbody>
             </table>
         </div>
     )
 }
