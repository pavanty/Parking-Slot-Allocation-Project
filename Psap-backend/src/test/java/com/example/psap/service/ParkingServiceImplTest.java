package com.example.psap.service;

import com.example.psap.dao.ParkingSlotsDao;
import com.example.psap.entity.Address;
import com.example.psap.entity.ParkingPremise;
import com.example.psap.entity.ParkingSlots;
import com.example.psap.exception.NoSuchParkingSlotException;
import com.example.psap.exception.ParkingSlotNotAvailableException;
import com.example.psap.service.IParkingService;
import com.example.psap.service.ParkingServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ParkingServiceImplTest {

    @InjectMocks
    private IParkingService iparkingservice = new ParkingServiceImpl();

    @Mock
    private ParkingSlotsDao parkingslotsdao;

    @Test
    void  testBookParkingSlots() {
        ParkingSlots parkingSlots = new ParkingSlots();


        ParkingPremise parkingPremise= new ParkingPremise();

        Address address = new Address();

        address.setAddressId(1);
        address.setCity("bangalore");
        address.setPin("560043");
        address.setState("karnataka");

        parkingPremise.setParkingPremiseId(1);
        parkingPremise.setParkingPremiseName("Banglore");
        parkingPremise.setAddressId(address);
        parkingPremise.setNumberOfParkingFloors(1);

        parkingSlots.setParkingSlotId(1);
        parkingSlots.setParkingDate("2022-07-01");
        parkingSlots.setParkingDuration(12);
        parkingSlots.setParkingTime("9");



        when(parkingslotsdao.save(parkingSlots)).thenReturn(parkingSlots);
        ParkingSlots myParkingSlot;
        myParkingSlot=iparkingservice.bookParkingSlots(parkingSlots,8);
        assertEquals(1,myParkingSlot.getParkingSlotId());

    }

    @Test
    void getParkingSlotsById() throws NoSuchParkingSlotException {
        ParkingSlots parkingSlots = new ParkingSlots();


        ParkingPremise parkingPremise= new ParkingPremise();

        Address address = new Address();

        address.setAddressId(1);
        address.setCity("bangalore");
        address.setPin("560043");
        address.setState("karnataka");

        parkingPremise.setParkingPremiseId(1);
        parkingPremise.setParkingPremiseName("Banglore");
        parkingPremise.setAddressId(address);
        parkingPremise.setNumberOfParkingFloors(1);

   


        parkingSlots.setParkingSlotId(1);
        parkingSlots.setParkingDate("2022-07-11");
        parkingSlots.setParkingDuration(12);
        parkingSlots.setParkingTime("9");
       
        Optional<ParkingSlots> optionalParkingSlots = Optional.of(parkingSlots);

        when(parkingslotsdao.findById(1)).thenReturn(optionalParkingSlots);
        ParkingSlots myParkingSlots;
        myParkingSlots = iparkingservice.getParkingSlotsById(Integer.valueOf("1"));
        assertEquals("9", myParkingSlots.getParkingTime());

    }
    @Test
    void cancelParkingSlotBooking() throws NoSuchParkingSlotException {
        ParkingSlots parkingSlots = new ParkingSlots();


      

        ParkingPremise parkingPremise= new ParkingPremise();

        Address address = new Address();

        address.setAddressId(1);
        address.setCity("bangalore");
        address.setPin("560043");
        address.setState("karnataka");

        parkingPremise.setParkingPremiseId(1);
        parkingPremise.setParkingPremiseName("Banglore");
        parkingPremise.setAddressId(address);
        parkingPremise.setNumberOfParkingFloors(1);

       


        parkingSlots.setParkingSlotId(1);
        parkingSlots.setParkingDate("2022-07-11");
        parkingSlots.setParkingDuration(12);
        parkingSlots.setParkingTime("9");
       

        Optional<ParkingSlots> optionalParkingSlots = Optional.of(parkingSlots);

        when(parkingslotsdao.findById(1)).thenReturn(optionalParkingSlots);
        iparkingservice.cancelParkingSlotBooking(1);

        verify(parkingslotsdao,times(1)).findById(1);
        verify(parkingslotsdao,times(1)).deleteById(1);
    }

    @Test
    void getAllParkingSlots() {
        ParkingSlots parkingSlots = new ParkingSlots();


        ParkingPremise parkingPremise= new ParkingPremise();

        Address address = new Address();

        address.setAddressId(1);
        address.setCity("bangalore");
        address.setPin("560043");
        address.setState("karnataka");

        parkingPremise.setParkingPremiseId(1);
        parkingPremise.setParkingPremiseName("Banglore");
        parkingPremise.setAddressId(address);
        parkingPremise.setNumberOfParkingFloors(1);

       


        parkingSlots.setParkingSlotId(1);
        parkingSlots.setParkingDate("2022-07-11");
        parkingSlots.setParkingDuration(12);
        parkingSlots.setParkingTime("9");
       

        ParkingSlots parkingSlots2 = new ParkingSlots();
        parkingSlots.setParkingSlotId(2);
        parkingSlots.setParkingDate("2022-06-10");
        parkingSlots.setParkingDuration(10);
        parkingSlots.setParkingTime("8");
        
        ParkingSlots parkingSlots3 = new ParkingSlots();
        parkingSlots.setParkingSlotId(3);
        parkingSlots.setParkingDate("2022-06-14");
        parkingSlots.setParkingDuration(11);
        parkingSlots.setParkingTime("7");
        

        List<ParkingSlots> parkingSlotsList= new ArrayList<>();
        parkingSlotsList.add(parkingSlots);
        parkingSlotsList.add(parkingSlots2);
        parkingSlotsList.add(parkingSlots3);

        when(parkingslotsdao.findAll()).thenReturn(parkingSlotsList);
        List<ParkingSlots>parkingSlots1=iparkingservice.getAllParkingSlots();
        assertEquals(3,parkingSlots1.size());

    }

    @Test
    void checkAvailability() throws ParkingSlotNotAvailableException {
        ParkingSlots parkingSlots = new ParkingSlots();


        ParkingPremise parkingPremise= new ParkingPremise();

        Address address = new Address();

        address.setAddressId(1);
        address.setCity("bangalore");
        address.setPin("560043");
        address.setState("karnataka");

        parkingPremise.setParkingPremiseId(1);
        parkingPremise.setParkingPremiseName("Banglore");
        parkingPremise.setAddressId(address);
        parkingPremise.setNumberOfParkingFloors(1);

      

        parkingSlots.setParkingSlotId(1);
        parkingSlots.setParkingDate("2022-07-11");
        parkingSlots.setParkingDuration(12);
        parkingSlots.setParkingTime("9");
       

        Optional<ParkingSlots> optionalParkingSlots = Optional.of(parkingSlots);

        when(parkingslotsdao.findByParkingDateAndParkingTime("2022-07-11","9")).thenReturn(optionalParkingSlots);
        iparkingservice.checkAvailability("2022-07-11","9");
        assertEquals(1,optionalParkingSlots.get().getParkingSlotId());

    }
}