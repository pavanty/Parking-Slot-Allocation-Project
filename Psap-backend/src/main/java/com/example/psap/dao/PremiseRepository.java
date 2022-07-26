package com.example.psap.dao;

import com.example.psap.entity.ParkingPremise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PremiseRepository extends JpaRepository<ParkingPremise,Integer> {
    Optional<ParkingPremise> findById(Integer parkingPremiseId);

    Optional<ParkingPremise> findByparkingPremiseName(String parkingPremiseName);
}
