package com.example.psap.controller;


import com.example.psap.entity.Vehicle;
import com.example.psap.service.IParkingService;
import com.example.psap.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/vehicle")
@CrossOrigin("*")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @Autowired
    private IParkingService iParkingService;


	//TODO add vehicles
    @PostMapping("/addvehicle")
    public ResponseEntity<Vehicle> addvehicle(@RequestBody Vehicle vehicle,@RequestParam int user_id) {
        return new ResponseEntity<Vehicle>(vehicleService.addUsersVehicle(vehicle,user_id), HttpStatus.CREATED);

    }

    //TODO Fetch the vehicle by vehicle Id
    @GetMapping("/fetchvehiclebyid/{vehicleId}")
    public Vehicle fetchVehicleByVehicleId(@PathVariable Integer vehicleId) {
        return vehicleService.fetchVehicleByVehicleId(vehicleId);
    }

	//TODO find vehicle by vehicle number
    @GetMapping("{vehicleNumber}")
    public Vehicle fetchVehicleByVehicleNumber(@PathVariable String vehicleNumber) {
        return vehicleService.findVehicleByVehicleNumber(vehicleNumber);
    }
	//TODO To get all Vehicles
    @GetMapping(value = "/getallvehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicle() {
        List<Vehicle> v = vehicleService.getallvehicles();
        return new ResponseEntity<List<Vehicle>>(v, HttpStatus.OK);
    }

	//TODO Update the vehicle by Id
    @PutMapping(value = "/update/{vehicleId}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Integer vehicleId, @RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(vehicleId, vehicle);
        return new ResponseEntity<Vehicle>(updatedVehicle, HttpStatus.CREATED);
    }


	//TODO remove vehicle by vehicle number
    @DeleteMapping(value = "/deletevehicle/{vehicleNumber}")
    public ResponseEntity<String> deletevehicle(@PathVariable String vehicleNumber) {
        vehicleService.removeVehicleByVehicleNumber(vehicleNumber);
        String msg = "Vehicle with number: " + vehicleNumber + " Deleted Successfully";
        return new ResponseEntity<String>(msg, HttpStatus.OK);

    }

	//TODO TO Modify the Vehicle
    @PutMapping("/modifyTheVehicle")
    public ResponseEntity<?> modifyVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.modifyVehicle(vehicle);
        return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
    }

}
	
	
