import React, { Component } from "react";
import ParkingService from "./services/ParkingService";
import Loginuserinfo from "../component/Loginuserinfo";
import {Link} from "react-router-dom";

export class BookParkingSlot extends Component {
    constructor(props) {
        super(props);

        this.state = {

            vehicleId: "",

            parkingDate: "",
            parkingTime: "",
            parkingDuration: "",
            
            type: "",
            paymentDateTime: "",
            amountPaid: "",
            status: "",

            parkingPremiseName: "",
            numberOfParkingFloors: "",

            city: "",
            state: "",
            pin: "",

        };
    }

    handleVehicleId = (event) => {
        this.setState({
            vehicleId: event.target.value,
        });
    };
    

    handleParkingDate = (event) => {
        this.setState({
            parkingDate: event.target.value,
        });
    };
    handleParkingTime = (event) => {
        this.setState({
            parkingTime: event.target.value,
        });
    };
    handleParkingDuration = (event) => {
        this.setState({
            parkingDuration: event.target.value,
        });
    };
    handleType = (event) => {
        this.setState({
            type: event.target.value,
        });
    };
    handlePaymentDateTime = (event) => {
        this.setState({
            paymentDateTime: event.target.value,
        });
    };
    handleAmountPaid = (event) => {
        this.setState({
            amountPaid: event.target.value,
        });
    };
    handleStatus = (event) => {
        this.setState({
            status: event.target.value,
        });
    };
    handleParkingPremiseName = (event) => {
        this.setState({
            parkingPremiseName: event.target.value,
        });
    };
    handleNumberOfParkingFloors = (event) => {
        this.setState({
            numberOfParkingFloors: event.target.value,
        });
    };
    handleCity = (event) => {
        this.setState({
            city: event.target.value,
        });
    };
    handleState = (event) => {
        this.setState({
            state: event.target.value,
        });
    };
    handlePin = (event) => {
        this.setState({
            pin: event.target.value,
        });
    };

    handleFormSubmission = (event) => {
        event.preventDefault();
       this.SaveSlot();
        console.log(this.state);
    };

    SaveSlot() {
        const payload = {
            parkingDate: this.state.parkingDate,
            parkingTime: this.state.parkingTime,
            parkingDuration: this.state.parkingDuration,
            payment: {
              type: this.state.type,
              paymentDateTime: this.state.paymentDateTime,
              amountPaid: this.state.amountPaid,
              status: this.state.status,
            },
            parkingPremise: {
              parkingPremiseName: this.state.parkingPremiseName,
              numberOfParkingFloors: this.state.numberOfParkingFloors,
              addressId: {
                city: this.state.city,
                state: this.state.state,
                pin: this.state.pin,
              }
            }
          }
        
          ParkingService.addparkingslot(this.state.vehicleId,payload)
            .then((response) => {
                console.log(response);
                this.setState({
                    msg: "PARKING SLOT BOOKED SUCCESSFULLY",
                });
            })
            .catch((error) => {
                console.log(error);
                this.setState({
                    msg: "Enter Valid Details",
                });
            });
    }
    
    render() {
        return (
            
            <div style={{background:"#BBDAF6"}} className="container mt-3">
              <Link to={'/menu'} className="btn btn-primary mt-2">Go back</Link>
                <h2>Book Parking slot</h2>
                <hr />
                <form className="form-wrapper" onSubmit={this.handleFormSubmission}>

                    <div className=" form-group">
                        <label>Vehicle ID </label>
                        <input
                            type="text"
                            id="Vehicle ID"
                            className="form-control" required
                            placeholder="Enter Vehicle ID"
                            value={this.state.vehicleId}
                            onChange={this.handleVehicleId} />
                    </div>

                    <div className=" form-group">
                        <label>Parking Date</label>
                        <input
                            type="text"
                            id="date"
                            className="form-control" required
                            placeholder="Enter Date"
                            value={this.state.parkingDate}
                            onChange={this.handleParkingDate} />
                    </div>

                    <div className=" form-group">
                        <label>Parking Time</label>
                        <input
                            type="text"
                            id="time"
                            className="form-control" required
                            placeholder="Enter Date"
                            value={this.state.parkingTime}
                            onChange={this.handleParkingTime} />
                    </div>

                    <div className=" form-group">
                        <label>Parking Duration</label>
                        <input
                            type="text"
                            id="duration"
                            className="form-control" required
                            placeholder="Enter Duration of Parking"
                            value={this.state.parkingDuration}
                            onChange={this.handleParkingDuration} />
                    </div>

                    <div className=" form-group">
                        <label>Payment Type</label>
                        <input
                            type="text"
                            id="type"
                            className="form-control" required
                            placeholder="Enter Vehicle Type"
                            value={this.state.type}
                            onChange={this.handleType} />
                    </div>

                    <div className=" form-group">
                        <label>Payment Date</label>
                        <input
                            type="text"
                            id="paymentdate"
                            className="form-control" required
                            placeholder="Enter Payment Date"
                            value={this.state.paymentDateTime}
                            onChange={this.handlePaymentDateTime} />
                    </div>

                    <div className=" form-group">
                        <label>Amount Paid</label>
                        <input
                            type="text"
                            id="amountpaid"
                            className="form-control" required
                            placeholder="Enter Amount Paid"
                            value={this.state.amountPaid}
                            onChange={this.handleAmountPaid} />
                    </div>

                    <div className=" form-group">
                        <label>Payment Status</label>
                        <input
                            type="text"
                            id="status"
                            className="form-control" required
                            placeholder="Enter Payment Status"
                            value={this.state.status}
                            onChange={this.handleStatus} />
                    </div>

                    <div className=" form-group">
                        <label>Parking Premise Name</label>
                        <input
                            type="text"
                            id="premisename"
                            className="form-control" required
                            placeholder="Enter Payment Status"
                            value={this.state.parkingPremiseName}
                            onChange={this.handleParkingPremiseName} />
                    </div>

                    <div className=" form-group">
                        <label>Parking Floor</label>
                        <input
                            type="text"
                            id="parkingfloor"
                            className="form-control" required
                            placeholder="Enter Parking Floor"
                            value={this.state.numberOfParkingFloors}
                            onChange={this.handleNumberOfParkingFloors} />
                    </div>

                    <div className=" form-group">
                        <label>City</label>
                        <input
                            type="text"
                            id="city"
                            className="form-control" required
                            placeholder="Enter City"
                            value={this.state.city}
                            onChange={this.handleCity} />
                    </div>

                    <div className=" form-group">
                        <label>State</label>
                        <input
                            type="text"
                            id="state"
                            className="form-control" required
                            placeholder="Enter State"
                            value={this.state.state}
                            onChange={this.handleState} />
                    </div>

                    <div className=" form-group">
                        <label>Pincode</label>
                        <input
                            type="text"
                            id="pincode"
                            className="form-control" required
                            placeholder="Enter Pincode"
                            value={this.state.pincode}
                            onChange={this.handlePin} />
                    </div>

                    <button onClick={this.handleFormSubmission} className="btn btn-primary mt-2">Submit</button>

                </form>

                {this.state.msg && (
                    <h5 className="alert alert-success mt-2">{this.state.msg}</h5>
                )}

            </div>
        );
    }
}