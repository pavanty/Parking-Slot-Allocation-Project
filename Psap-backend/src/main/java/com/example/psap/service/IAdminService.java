package com.example.psap.service;

import java.util.List;
import java.util.Optional;

import com.example.psap.entity.Admin;
import com.example.psap.entity.ParkingPremise;

public interface IAdminService {

	public boolean login1(String username,String password);

	public Admin saveParkingPremise(Admin admin);

	List<ParkingPremise> getAllPremise();

	Optional<ParkingPremise> getPremise(Integer parkingPremiseId);

	Optional<ParkingPremise> getPremiseByName(String parkingPremiseName);

	public ParkingPremise deleteParkingPremise(Integer id);

	public ParkingPremise updateParkingPremise(Integer parkingPremiseId, ParkingPremise premise);

	public ParkingPremise createParkingPremise(ParkingPremise premise);
}