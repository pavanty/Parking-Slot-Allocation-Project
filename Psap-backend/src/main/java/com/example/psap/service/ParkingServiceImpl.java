package com.example.psap.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.psap.dao.PaymentDao;
import com.example.psap.dao.PremiseRepository;
import com.example.psap.dao.Vehicledao;
import com.example.psap.exception.NoSuchVehicleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.psap.dao.ParkingSlotsDao;
import com.example.psap.entity.ParkingSlots;
import com.example.psap.exception.NoSuchParkingSlotException;
import com.example.psap.exception.ParkingSlotNotAvailableException;




@Service
public class ParkingServiceImpl implements IParkingService {
	
	@Autowired
	ParkingSlotsDao psdao;
	@Autowired
	Vehicledao vehicledao;
	@Autowired
	PaymentDao paymentDao;
	@Autowired
	PremiseRepository premiseRepository;

	
	
	
	
	//book parking slot details
	@Override
	public ParkingSlots bookParkingSlots(ParkingSlots parkingslot, int vehicle_id) {
		parkingslot.setVehicle(vehicledao.getById(vehicle_id));
		premiseRepository.save(parkingslot.getParkingPremise());
		paymentDao.save(parkingslot.getPayment());
		return psdao.save(parkingslot);
	}

	//get slot by id
		@Override
		public ParkingSlots getParkingSlotsById(Integer parkingSlotId) throws NoSuchParkingSlotException {

			return psdao.findById(parkingSlotId)
					.orElseThrow(()-> new NoSuchParkingSlotException("ParkingSlot with Id " + parkingSlotId +" not found"));
		}

		
		 //p\cancel parking slot
		
		@Override
		public void cancelParkingSlotBooking(Integer parkingSlotId) throws NoSuchParkingSlotException {

		ParkingSlots ps = getParkingSlotsById(parkingSlotId);
		psdao.deleteById(ps.getParkingSlotId());

		}
		//get all Parking slots
			@Override
			public List<ParkingSlots> getAllParkingSlots() {
				
				return psdao.findAll();
			}

//	@Override
//	public void removeVehicleByVehicleNumberslot(String vehicleNumber, ParkingSlots parkingSlots) {
//		Optional<ParkingSlots> parkingSlots1=psdao.findByVechileNumber(vehicleNumber);
//		if(parkingSlots1.isPresent()){
//			psdao.deleteAll();
//		}
//	}

//	@Override
//	public ParkingSlots deleteparkingslotsbyvehiclenumber(String vehicleNumber, Integer parkingSlotId, ParkingSlots parkingSlots) {
//		Optional<ParkingSlots> parkingSlots1=psdao.findByvechileslotnumber(vehicleNumber);
//		if(parkingSlots1.isPresent()){
//			psdao.deleteById(parkingSlotId);
//		}
//		else{
//			throw new NoSuchVehicleException("Vehicle with the Vehicle Number is Not Existing");
//		}
//		return parkingSlots1.get();
//	}

//	@Override
//
//	public void deleteparkingslotsbyvehiclenumber(String vehicleNumber, ParkingSlots parkingSlots) {
//		Optional<ParkingSlots> parkingSlots1=psdao.findByvechileslotnumber(vehicleNumber);
//		if(parkingSlots1.isPresent()){
//			psdao.delete
//		}


	//Check Slot availability
	
		@Override
		public boolean checkAvailability(String date, String time) throws ParkingSlotNotAvailableException {
			Optional<ParkingSlots> p = psdao.findByParkingDateAndParkingTime(date, time);
			if (p != null)
				return false;
			else
			return true;
		}
		
	  
	 
	



	
	

}

