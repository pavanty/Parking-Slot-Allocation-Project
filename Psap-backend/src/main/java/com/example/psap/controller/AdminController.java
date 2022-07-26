package com.example.psap.controller;

import java.util.List;
import java.util.Optional;

import com.example.psap.entity.LoginA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.psap.entity.Admin;
import com.example.psap.entity.ParkingPremise;
import com.example.psap.service.IAdminService;

import javax.validation.Valid;


@RestController
@RequestMapping(value="/admin")
@CrossOrigin("*")
public class AdminController
{
	@Autowired
	private IAdminService adminService;

	@PostMapping(value="/add")
	public ResponseEntity<Admin> saveParkingPremise(@RequestBody Admin admin)
	{
		return new ResponseEntity<Admin>(adminService.saveParkingPremise(admin), HttpStatus.CREATED);
	}

	@PostMapping(value="/loginA")
	public ResponseEntity<String> login1(@RequestBody LoginA loginA) {

		Boolean isLoginSuccess=adminService.login1(loginA.getUsername(), loginA.getPassword());
		String msg="";
		if(isLoginSuccess)
		{
			msg="welcome "+ loginA.getUsername();
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		else
		{
			msg="Invalid Credential,Try Again";
			return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(value="/getallPremise")
	public ResponseEntity<List<ParkingPremise>> getAllPremise()
	{
		List<ParkingPremise> allPremise=adminService.getAllPremise();
		return new ResponseEntity<List<ParkingPremise>>(allPremise, HttpStatus.OK);
	}

	@GetMapping(value="getPremiseById/{parkingPremiseId}")
	public ResponseEntity<Optional<ParkingPremise>> getPremise(@PathVariable Integer parkingPremiseId)
	{
		Optional<ParkingPremise> premiseById=adminService.getPremise(parkingPremiseId);
		return new ResponseEntity<Optional<ParkingPremise>>(premiseById, HttpStatus.OK);
	}

	@GetMapping(value="getPremiseByName/{parkingPremiseName}")
	public ResponseEntity<Optional<ParkingPremise>> getPremise(@PathVariable String parkingPremiseName)
	{
		Optional<ParkingPremise> premiseByName=adminService.getPremiseByName(parkingPremiseName);
		return new ResponseEntity<Optional<ParkingPremise>>(premiseByName, HttpStatus.OK);
	}

	@DeleteMapping(value="/removePremise/{parkingPremiseId}")
	public ResponseEntity<String> deleteParkingPremise(@PathVariable Integer parkingPremiseId)
	{
		adminService.deleteParkingPremise(parkingPremiseId);
		String msg = "Premise with Id "+parkingPremiseId+" Deleted Successfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}



	@PutMapping(value="/modifyPremise/{parkingPremiseId}")
	public ResponseEntity<ParkingPremise> updateParkingPremise(@PathVariable Integer parkingPremiseId,@RequestBody ParkingPremise premise)
	{
		ParkingPremise updateParkingPremise = adminService.updateParkingPremise(parkingPremiseId, premise);
		return new ResponseEntity<ParkingPremise>(updateParkingPremise,HttpStatus.CREATED);
	}

	@PostMapping(value="/addPremise")
	public ResponseEntity<ParkingPremise> createParkingPremise(@Valid @RequestBody ParkingPremise premise)
	{
		return new ResponseEntity<ParkingPremise>(adminService.createParkingPremise(premise), HttpStatus.CREATED);
	}
}