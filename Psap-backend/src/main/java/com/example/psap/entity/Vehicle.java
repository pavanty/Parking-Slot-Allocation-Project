package com.example.psap.entity;


import javax.persistence.*;

@Entity

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "vehicle_id")
    private int vehicleId;
    @Column
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    @Column
    private String vehicleNumber;
    @Column
    private String vehicleCompany;
    @Column
    private String vehicleModel;

    @OneToOne
    private Users users;

    public Vehicle() {
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleCompany() {
        return vehicleCompany;
    }

    public void setVehicleCompany(String vehicleCompany) {
        this.vehicleCompany = vehicleCompany;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


    public Vehicle(int vehicleId, VehicleType vehicleType, String vehicleNumber, String vehicleCompany, String vehicleModel, Users users) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.vehicleCompany = vehicleCompany;
        this.vehicleModel = vehicleModel;
        this.users = users;
    }


}

