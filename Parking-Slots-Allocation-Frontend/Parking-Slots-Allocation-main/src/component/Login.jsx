import React from "react"
import axios from "axios"
import {Link} from 'react-router-dom';
import Menu1 from "../component/Menu1";
import Loginuserinfo from "../component/Loginuserinfo";
export class Login extends React.Component{
    constructor(props){
        super(props)

        this.state={
            username:'',
            password:'',
            successMsg:'',
            failedMsg:'',
            loggedIn:false
        }
    }
    handleUsername=(event)=>
    {
        this.setState({
            username:event.target.value

        })

    }

    handleLogout=()=>
    {
        this.setState({loggedIn:false})
    }


   
    handlePassword=(event)=>
    {
        this.setState({
            password:event.target.value
        })
    }
    

    handleFormSubmission=(event)=>
    {
        console.log(this.state)
        event.preventDefault()
        axios.post('http://localhost:8087/user/login',this.state)
                .then((response)=>
                {   alert("The user login is successful UserId : "+response.data.user_id);
                    console.log(response.data.msg)
                    if(response.data.msg!=="Invalid Credentials,Try again")
                    {
                    this.setState({
                        username:'',
                        password:'',
                        successMsg:"",
                        loggedIn:true
                    })
                }
                else{
                    this.setState({
                        username:'',
                        password:'',
                        successMsg:'',
                        failedMsg:response.data.msg,
                        loggedIn:false
                    })

                }

                    
                })
                .catch(error=>alert("No such user found"))
    }

    render(){
        if(!this.state.loggedIn)
        {
            return(
                <React.Fragment>
                <div style={{background:"#BBDAF6"}} className="container mt-3">
                <h2>Login Page</h2>
                <hr/>
                <form onSubmit={this.handleFormSubmission}>
                    <div className="form-group">
                        <label>Username</label>
                        <input onChange={this.handleUsername} value={this.state.username} className="form-control"required/>
                    </div>
                    <div>
                        <label>Password</label>
                        <input onChange={this.handlePassword} value={this.state.password} type="password" className="form-control"required/>
                    </div>    
                    <button type="submit" className="btn btn-primary mt-2">Login</button>
                    
                </form>
                
                </div>
                <h5 className="text-danger">{this.state.failedMsg}</h5>
                </React.Fragment>
                
            )

        }
        else{

            return(
                <center><div className="container mt-2">
                    <Loginuserinfo/>
                    
                </div>
                </center>
            )

        }

    }

}