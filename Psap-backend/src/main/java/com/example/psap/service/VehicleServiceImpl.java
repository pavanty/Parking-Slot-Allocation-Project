package com.example.psap.service;


import com.example.psap.dao.UserRepository;
import com.example.psap.dao.Vehicledao;
import com.example.psap.entity.Vehicle;
import com.example.psap.exception.DuplicateVehicleException;
import com.example.psap.exception.NoSuchVehicleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    Vehicledao vehicleDao;


    @Autowired
    UserRepository userRepository;

    //TODO add vehicle
    @Override
    public Vehicle addUsersVehicle(Vehicle vehicle, int user_id) throws DuplicateVehicleException {
        Optional<Vehicle> vehicle2 = vehicleDao.findById(vehicle.getVehicleId());
        vehicle.setUsers(userRepository.getById(user_id));
        return vehicleDao.save(vehicle);

    }

    //TODO find vehicle details by vehicle number
    @Override
    public Vehicle findVehicleByVehicleNumber(String vehicleNumber) {
        Optional<Vehicle> opt = vehicleDao.findByVehicleNumber(vehicleNumber);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new NoSuchVehicleException("No Vehicle Found");
        }
    }

    //TODO to get all vehicles
    @Override
    public List<Vehicle> getallvehicles() {
        return vehicleDao.findAll();
    }

    //TODO remove vehicle by vehicle number
    @Override
    public Vehicle removeVehicleByVehicleNumber(String vehicleNumber) {
        Optional<Vehicle> vehicle2 = vehicleDao.findByVehicleNumber(vehicleNumber);
        if (vehicle2.isPresent()) {
            vehicleDao.deleteByVehicleNumber(vehicleNumber);
        } else {
            throw new NoSuchVehicleException("Vehicle with the Vehicle Number is Not Existing");
        }
        return vehicle2.get();
    }

    //TODO modify the vehicle
    @Override
    public Vehicle modifyVehicle(Vehicle vehicle) {
        Optional<Vehicle> vehicle1 = vehicleDao.findById(vehicle.getVehicleId());
        if (vehicle1.isPresent()) {
            return vehicleDao.save(vehicle);
        } else {
            throw new NoSuchVehicleException("Vehicle with this Id is not Existing");
        }
    }

    //TODO Update the Vehicle
    @Override
    public Vehicle updateVehicle(Integer vehicleId, Vehicle vehicle) {
        Vehicle vehicle1 = vehicleDao.findById(vehicleId).get();
        if (Objects.nonNull(vehicle.getVehicleModel()) && !"".equalsIgnoreCase(vehicle.getVehicleModel())) {
            vehicle1.setVehicleModel(vehicle.getVehicleModel());
        }
        if (Objects.nonNull(vehicle.getVehicleCompany()) && !"".equalsIgnoreCase(vehicle.getVehicleCompany())) {
            vehicle1.setVehicleCompany(vehicle.getVehicleCompany());
        }
        if (Objects.nonNull(vehicle.getVehicleNumber()) && !"".equalsIgnoreCase(vehicle.getVehicleNumber())) {
            vehicle1.setVehicleNumber(vehicle.getVehicleNumber());
        }
        return vehicleDao.save(vehicle1);
    }

    //TODO Fetch the vehicle by Vehicle ID
    @Override
    public Vehicle fetchVehicleByVehicleId(Integer vehicleId) {
        Optional<Vehicle> opt = vehicleDao.findById(vehicleId);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new NoSuchVehicleException("No Vehicle Found");
        }
    }
}