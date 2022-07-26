package com.example.psap.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
	@Table()
	public class ParkingSlots {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parkingSlotId;

	@Column
	private String parkingDate;

	@Column
	private String parkingTime;

	@Column
	private int parkingDuration;


	@OneToOne
//	@JoinColumn(name = "vehicleId")
	private Vehicle vehicle;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentId")
	private Payment payment;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parkingPremiseId")
	private ParkingPremise parkingPremise;

	public int getParkingSlotId() {
		return parkingSlotId;
	}


	public void setParkingSlotId(int parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}

	public String getParkingDate() {
		return parkingDate;
	}

	public void setParkingDate(String parkingDate) {
		this.parkingDate = parkingDate;
	}

	public String getParkingTime() {
		return parkingTime;
	}

	public void setParkingTime(String parkingTime) {
		this.parkingTime = parkingTime;
	}

	public int getParkingDuration() {
		return parkingDuration;
	}

	public void setParkingDuration(int parkingDuration) {
		this.parkingDuration = parkingDuration;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public ParkingPremise getParkingPremise() {
		return parkingPremise;
	}

	public void setParkingPremise(ParkingPremise parkingPremise) {
		this.parkingPremise = parkingPremise;
	}


}


