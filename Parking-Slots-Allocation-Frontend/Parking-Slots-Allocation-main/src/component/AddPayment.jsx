import React,{ Component } from "react";
import  AddPaymentService  from "./services/AddPaymentService";
import {Link} from 'react-router-dom';
export  class AddPayment extends Component{
    constructor(props)
    {
        super(props)
        this.state={
            //paymentId:'',
            amountPaid:'',
            paymentDateTime:'',
            status:'',
            type:'',
            msg:''
        }
    }
    
   
    handleAmountPaid=(event)=>
    {
        this.setState({
            amountPaid:event.target.value
        })
    }
    handlePaymentDateTime=(event)=>
    {
        this.setState({
            paymentDateTime:event.target.value
        })
    }

    handleStatus=(event)=>
    {
        this.setState({
            status:event.target.value
        })
    }
     handleType=(event)=>
    {
        this.setState({
            type:event.target.value
        })
    }
    handleForSubmission=(event)=>
    {
        event.preventDefault()
        this.savePayment(this.state)      
    }
    savePayment(payment)
    {

        AddPaymentService.addPayment(payment).then( response=>alert("The payment status is uploaded")).catch(error=>alert("Please enter valid data"));

    }
    render()
    {
        
        return(
            <div style={{background:"#BBDAF6"}} className="container mt-3">
                <Link to={'/menu'} className="btn btn-primary mt-2">Go back</Link>
                <h2>Add Payment</h2>
                <hr/>
                <form onSubmit={this.handleForSubmission}>
                

                    <div className="form-group">
                        <label> Amount Paid </label>
                        <input  onChange={this.handleAmountPaid} value={this.state.amountPaid}className="form-control"required/>
                    </div>
                    <div className="form-group">
                        <label> PaymentDateTime </label>
                        <input  onChange={this.handlePaymentDateTime} value={this.state.paymentDateTime} className="form-control"required/>

                    </div>
                    <div className="form-group">
                        <label> Status </label>
                        <input  onChange={this.handleStatus} value={this.state.status} className="form-control"required/>

                    </div>
                     
                    <div className="form-group">
                        <label> Type </label>
                        <input  onChange={this.handleType} value={this.state.type} className="form-control"required/>

                    </div>
                    <div>
                    <button className="btn btn-primary mt-2"> Add </button>
                    </div>
                </form>
                {
                    this.state.msg && <h5 className="alert alert-successs mt-2"> {this.state.msg}</h5>
                }

            </div>
        )
    }

}