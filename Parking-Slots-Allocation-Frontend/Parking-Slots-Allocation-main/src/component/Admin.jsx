import React from "react"
import AdminService from "./services/AdminService"



export default class Admin extends React.Component{

    constructor(props){
        super(props)

        this.state={
            id:'',
           username:'',
            password:'',
            msg:'',
            error:''

        }
    }

    handleId=(event)=>
    {
        this.setState({
            id:event.target.value

        })
    }
   
    handleName=(event)=>
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

   

    handleForSubmission=(event)=>
    {
        event.preventDefault()
        this.saveParkingPremise(this.state)
    }

    saveParkingPremise(admin)
    {
        AdminService. saveParkingPremise(admin).then(response=>
            {  
                console.log(response)
                this.setState({
                    id:'',
                    username:'',
                    password:'',
                    msg:"Admin added successfully",
                    error:''        
                    
                })
            })
            .catch(error=>console.log(error))

    }

    render()
    {
        return(
            <div style={{background:"#BBDAF6"}} className="container">
            <h2 style={{color:"black"}} className="container mt-3">Admin Registration</h2>
            <hr />
            <form onSubmit={this.handleForSubmission}>
                <div  className="form-group">
                    <label>Id</label>
                    <input onChange={this.handleId} value={this.state.id} placeholder="Id" className="form-control"required />
                </div>
                <div  className="form-group">
                    <label>Name</label>
                    <input onChange={this.handleName} value={this.state.username} placeholder="Name" className="form-control"required />
                </div>
                
                <div className="form-group">
                    <label>Password</label>
                    <input onChange={this.handlePassword} value={this.state.password} placeholder="Password" type="password" className="form-control"required />
                </div>
               
               
                <button className="btn btn-primary mt-2" >Submit</button>
            </form>
                    {
                        this.state.msg && <h5 className="alert alert-success mt-2">{this.state.msg}</h5>
                    }
            </div>
        )
    }

    }