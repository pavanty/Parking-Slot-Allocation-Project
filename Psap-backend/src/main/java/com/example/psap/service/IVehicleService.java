package com.example.psap.service;

import com.example.psap.entity.Vehicle;
import com.example.psap.exception.DuplicateVehicleException;

import java.util.List;


public interface IVehicleService {


    Vehicle addUsersVehicle(Vehicle vehicle, int user_id) throws DuplicateVehicleException;

    public Vehicle findVehicleByVehicleNumber(String vehicleNumber);

    public List<Vehicle> getallvehicles();

    public Vehicle removeVehicleByVehicleNumber(String vehicleNumber);

    public Vehicle modifyVehicle(Vehicle vehicle);

    public Vehicle updateVehicle(Integer vehicleId, Vehicle vehicle);

    public Vehicle fetchVehicleByVehicleId(Integer vehicleId);


}

