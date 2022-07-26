import React from "react"
import UserService from "./services/UserService"



export class User extends React.Component{

    constructor(props){
        super(props)

        this.state={
            username:'',
            email:'',
            password:'',
            mobile:'',
            msg:'',
            error:''

        }
    }

    handleUserName=(event)=>
    {
        this.setState({
            username:event.target.value

        })
    }
   
    handleEmail=(event)=>
    {
        this.setState({
            email:event.target.value

        })
    }

    handlePassword=(event)=>
    {
        this.setState({
            password:event.target.value

        })
    }

    handleMobile=(event)=>
    {
        this.setState({
            mobile:event.target.value

        })
    }

   

    handleForSubmission=(event)=>
    {
        event.preventDefault()
        this.saveUser(this.state)
    }

    saveUser(user)
    {
        UserService.addUser(user).then(response=>
            {  
                console.log(response)
                this.setState({
                    username:'',
                    email:'',
                    password:'',
                    mobile:'',
                    msg:"User is successfully added",
                    error:''        
                    
                })
            })
            .catch(error=>alert("Wrong inputs...!\n(or)\nUser already exists"))

    }

    render()
    {
        return(
            <div>
            <div style={{background:"#BBDAF6"}} className="container">
            <h2 style={{color:"black"}} className="container mt-3">Registration</h2>
            <hr />
            <form onSubmit={this.handleForSubmission}>
                <div  className="form-group">
                    <label>User Name</label>
                    <input onChange={this.handleUserName} value={this.state.username} placeholder="Username" className="form-control" required/>
                </div>
                <div className="form-group">
                    <label>Email</label>
                    <input onChange={this.handleEmail} value={this.state.email} placeholder="Email" className="form-control" required/>
                </div>
                <div className="form-group">
                    <label>Password</label>
                    <input onChange={this.handlePassword} value={this.state.password} placeholder="Password" type="password" className="form-control"required />
                </div>
                <div className="form-group">
                    <label>Mobile</label>
                    <input onChange={this.handleMobile} value={this.state.mobile} placeholder="Mobile" className="form-control"required />
                </div>
               
                <button className="btn btn-primary mt-2" >Submit</button>
            </form>
                    {
                        this.state.msg && <h5 className="alert alert-success mt-2">{this.state.msg}</h5>
                    }
            </div>
            </div>
        )
    }

}