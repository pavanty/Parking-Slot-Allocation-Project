import React from "react"
import axios from "axios"
import Admindashboardinfo from "./Admindashboardinfo";
export class Login1 extends React.Component{
    constructor(props){
        super(props)

        this.state={
            userid:'',
            username:'',
            password:'',
            successMsg:'',
            failedMsg:'',
            loggedIn:false
        }
    }

    handleUserid=(event)=>
    {
        this.setState({
            userid:event.target.value

        })

    }

    handleUsername=(event)=>
    {
        this.setState({
            username:event.target.value

        })

    }

   
    handlePassword=(event)=>
    {
        this.setState({
            password:event.target.value
        })
    }
    handleLogout=()=>
    {
        this.setState({loggedIn:false})
    }


    handleFormSubmission=(event)=>
    {
        console.log(this.state)
        event.preventDefault()
        axios.post('http://localhost:8087/admin/loginA',this.state)
                .then((response)=>
                {   
                    console.log(response.data.msg)
                    if(response.data.msg!=="Invalid Credentials,Try again")
                    {
                    this.setState({
                        userid:'',
                        username:'',
                        password:'',
                        successMsg:"",
                        loggedIn:true
                    })
                }
                else{
                    this.setState({
                        userid:'',
                        username:'',
                        password:'',
                        successMsg:"Invalid Credentials",
                        failedMsg:'',
                        loggedIn:false
                    })

                }

                    
                })
                .catch(error=>alert("No such admin found"))
    }

    render(){
        if(!this.state.loggedIn)
        {
            return(
                <React.Fragment>
                <div style={{background:"#BBDAF6"}} className="container">
                <h2>Admin Login Page</h2>
                <hr/>
                <form onSubmit={this.handleFormSubmission}>
                <div className="form-group">
                        <label>Userid</label>
                        <input onChange={this.handleUserid} value={this.state.userid} className="form-control"required/>
                    </div>
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
                    <Admindashboardinfo /> 
                    
                </div>
                </center>
            )

        }

    }

}