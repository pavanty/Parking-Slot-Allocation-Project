import axios from 'axios'
import React , {useState,useEffect} from 'react'
import {Link} from "react-router-dom";
    
    export function ViewUser(){
    
        const[userId,setUserId]=useState()
        const[user,setUser]=useState({})
        const[Btn,setBtn]=useState()

        useEffect(()=>
        {
            axios.get(`http://localhost:8087/user/showUser/${userId}`)
            .then(response=>
                {
                    console.log(response.data)
                    setUser(response.data)
                })
                .catch(error=>alert("please enter valid details"))
        }, [Btn]
        )
    
        return(
            <div style={{background:"#BBDAF6"}} className="container mt-3">
              <Link to={'/menuA'} className="btn btn-primary mt-2">Go back</Link>
                <h3>Get User</h3>
                <hr/>
                <div className="form-group">
                    <label>User ID</label>
                    <input value={userId} onChange={(event)=>setUserId(event.target.value)} placeholder="User ID" className="form-control"required/>
    
                </div>
                <button onClick={()=>setBtn(userId)} className="btn btn-primary m-2">Search</button>
                <hr/>
                {
                    user && <div>
                        <h3>User ID: {userId} Details</h3>
                        <ul className="list-group">
                            <li className="list-group-item list-group-item-success">User ID: {user.user_id}</li>
                            <li className="list-group-item list-group-item-success">User Name : {user.username}</li>
                            <li className="list-group-item list-group-item-success">Email ID : {user.email}</li>
                           <li className="list-group-item list-group-item-success">Mobile NO : {user.mobile}</li>
                        </ul>
                        </div>
                }
            </div>
        )
    }