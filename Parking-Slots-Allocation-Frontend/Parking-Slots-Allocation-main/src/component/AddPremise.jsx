import React, { Component } from "react";
import AddPremiseService from "./services/AddPremiseService";
import Admindashboardinfo from "../component/Admindashboardinfo";

export class AddPremise extends Component {
    constructor(props) {
        super(props);

        this.state = {

            parkingPremiseName: "",
            numberOfParkingFloors: "",

            city: "",
            state: "",
            pin: "",

        };
    }
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
        this.SavePremise();
        console.log(this.state);
    };

    SavePremise() {
        const payload = {

            parkingPremiseName: this.state.parkingPremiseName,
            numberOfParkingFloors: this.state.numberOfParkingFloors,
            addressId: {
                city: this.state.city,
                state: this.state.state,
                pin: this.state.pin,
            }
        }


        AddPremiseService.addpremise(payload)
            .then((response) => {
                console.log(response);
                this.setState({
                    msg: "Premise Added SUCCESSFULLY",
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
            <><Admindashboardinfo /><div style={{background:"#BBDAF6"}} className="container mt-3">
                <h2 className="text-info">Add Premise</h2>
                <hr />
                <form className="form-wrapper" onSubmit={this.handleFormSubmission}>


                    <div className=" form-group">
                        <label>Parking Premise Name</label>
                        <input
                            type="text"
                            id="premisename"
                            className="form-control" required
                            placeholder="Enter Premise Name"
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

            </div></>
        );
    }
}