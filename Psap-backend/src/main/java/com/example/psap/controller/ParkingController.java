package com.example.psap.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.psap.entity.ParkingSlots;
import com.example.psap.exception.NoSuchParkingSlotException;
import com.example.psap.exception.ParkingSlotNotAvailableException;
import com.example.psap.service.IParkingService;

    
@ControllerAdvice
    @RestController
	@RequestMapping(value = "parkingslot")
    @CrossOrigin("*")
	public class ParkingController {
		
	
	
		@Autowired
		IParkingService pservice;
		
		
		
		//book parking slot
		@PostMapping(value= "/bookparkingslot")
		public ResponseEntity<ParkingSlots> Bookparkingslot(@Valid @RequestBody ParkingSlots parkingslot, @RequestParam int vehicle_id)
		{
			return new ResponseEntity<ParkingSlots>(pservice.bookParkingSlots(parkingslot,vehicle_id),HttpStatus.CREATED);
		
		}
		
		
	//get slot by id		
					
		@GetMapping("/findbyid/{parkingSlotId}")
		public ResponseEntity<ParkingSlots> getSlotbyid(@Valid  @PathVariable Integer parkingSlotId) throws NoSuchParkingSlotException{

	ParkingSlots ParkingSlotbyid = pservice.getParkingSlotsById(parkingSlotId);

		return new ResponseEntity<ParkingSlots>(ParkingSlotbyid, HttpStatus.OK);
}
	
	//Cancel Slot

	@DeleteMapping("/delete/{parkingslot}")
	public ResponseEntity<String> deleteSlot(@Valid @PathVariable Integer parkingslot) throws NoSuchParkingSlotException{
	    pservice.cancelParkingSlotBooking(parkingslot);
	    String msg = "Parking Slot With Id : " + parkingslot + " Deleted Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
//		@DeleteMapping("delete/{vehiclenumber}")
//		public  ResponseEntity<String> deletevehiclenumber(@PathVariable String vehicleNumber,@PathVariable Integer parkingSlotId, ParkingSlots parkingSlots){
//			pservice.deleteparkingslotsbyvehiclenumber(vehicleNumber,parkingSlotId,parkingSlots);
//			String msg = "Parking Slot With Id : " + vehicleNumber + " Deleted Successfully";
//			return new ResponseEntity<String>(msg,HttpStatus.OK);
//		}
//
	//Display all Parking Slots
	
	@GetMapping(value = "/allps")
	public ResponseEntity<List<ParkingSlots>> getAllParkingSlots() {
		List<ParkingSlots> p = pservice.getAllParkingSlots();
		return new ResponseEntity<List<ParkingSlots>>(p, HttpStatus.OK);
	}
	
	
	
	

		//Check Slot availability

		@GetMapping("checkavail/{date}/{time}")
		public ResponseEntity<String> checkAvailability(@PathVariable("date") String date, @PathVariable("time") String time) throws ParkingSlotNotAvailableException, ParseException {
			
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	     	Date date1 = simpleDateFormat.parse(date);
			
			if (pservice.checkAvailability(date, time)) {
				throw new ParkingSlotNotAvailableException("Slot unavailable");
			}
			else 
			return new ResponseEntity<String>("Slot available", HttpStatus.OK);
			
			}
	} 

