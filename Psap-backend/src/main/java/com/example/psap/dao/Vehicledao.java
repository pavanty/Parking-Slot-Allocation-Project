package com.example.psap.dao;


import com.example.psap.entity.Vehicle;
import com.example.psap.exception.NoSuchVehicleException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
public interface Vehicledao extends JpaRepository<Vehicle, Integer> {


    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) throws NoSuchVehicleException;


    public void save(String vehicleNumber);

    @Transactional
    @Modifying
    public void deleteByVehicleNumber(String vehicleNumber);


}

