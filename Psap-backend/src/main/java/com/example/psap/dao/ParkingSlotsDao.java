package com.example.psap.dao;

import java.util.Date;

import java.util.Optional;

import com.example.psap.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.psap.entity.ParkingSlots;


@Repository
public interface ParkingSlotsDao extends JpaRepository<ParkingSlots, Integer>{

//    static void deleteByVehicleNumber(String vehicleNumber) {
//    }

    Optional<ParkingSlots> findByParkingDateAndParkingTime(String d, String t);
	
	Optional<ParkingSlots> findById(Integer parkingSlotId);

//    Optional<ParkingSlots> findByVechileNumber(String vehicleNumber);


//    Optional<ParkingSlots> findByvechileslotnumber(String vehicleNumber);

    public ParkingSlots findFirstByOrderByParkingSlotIdDesc();

}
