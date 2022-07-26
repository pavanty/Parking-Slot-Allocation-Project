package com.example.psap.service;

import com.example.psap.dao.PremiseRepository;
import com.example.psap.dao.AdminRepository;
import com.example.psap.entity.Address;
import com.example.psap.entity.Admin;
import com.example.psap.entity.ParkingPremise;
import com.example.psap.service.IAdminService;
import com.example.psap.service.AdminServiceImplement;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class IAdminServiceTest {

    @InjectMocks
    private IAdminService iadminservice=new AdminServiceImplement();

    @Mock
    private AdminRepository adminRepository;
    @Mock
    private PremiseRepository premiseRepository;

    @Test
    public void getPremisebyIdtest(){
        ParkingPremise parkingPremise=new ParkingPremise();

        Address address = new Address();

        address.setAddressId(1);
        address.setCity("bangalore");
        address.setPin("560043");
        address.setState("karnataka");

        parkingPremise.setParkingPremiseId(1);
        parkingPremise.setParkingPremiseName("Vk Parking");
        parkingPremise.setAddressId(address);
        parkingPremise.setNumberOfParkingFloors(3);


        Optional<ParkingPremise> optionalPremise=Optional.of(parkingPremise);

        when(premiseRepository.findById(1)).thenReturn(optionalPremise);

        Optional<ParkingPremise> myPremise = iadminservice.getPremise(1);
        assertEquals("Vk Parking",myPremise.get().getParkingPremiseName());
    }

    @Test
    void getallPremisetest(){
        ParkingPremise premise = new ParkingPremise();

        Address address = new Address();

        address.setAddressId(1);
        address.setCity("bangalore");
        address.setPin("560043");
        address.setState("karnataka");

        premise.setParkingPremiseId(1);
        premise.setParkingPremiseName("PTY Parking");
        premise.setAddressId(address);
        premise.setNumberOfParkingFloors(2);

        ParkingPremise premise1 = new ParkingPremise();

        Address address1 = new Address();

        address.setAddressId(2);
        address.setCity("bangalore");
        address.setPin("560043");
        address.setState("karnataka");

        premise1.setParkingPremiseId(2);
        premise1.setParkingPremiseName("Vk Parking");
        premise1.setAddressId(address1);
        premise1.setNumberOfParkingFloors(3);

        ParkingPremise premise2 = new ParkingPremise();

        Address address2 = new Address();

        address.setAddressId(3);
        address.setCity("bangalore");
        address.setPin("560043");
        address.setState("karnataka");

        premise2.setParkingPremiseId(3);
        premise2.setParkingPremiseName("Rraj Parking");
        premise2.setAddressId(address2);
        premise2.setNumberOfParkingFloors(1);


        List<ParkingPremise> premiseList=new ArrayList<>();
        premiseList.add(premise);
        premiseList.add(premise1);
        premiseList.add(premise2);

        when(premiseRepository.findAll()).thenReturn(premiseList);
        List<ParkingPremise>premises=iadminservice.getAllPremise();
        assertEquals(3,premises.size());
    }

    @Test
    void removePremiseById(){
        ParkingPremise premise=new ParkingPremise();
        Address address = new Address();

        address.setAddressId(1);
        address.setCity("bangalore");
        address.setPin("560043");
        address.setState("karnataka");

        premise.setParkingPremiseId(1);
        premise.setParkingPremiseName("Vk Parking");
        premise.setAddressId(address);
        premise.setNumberOfParkingFloors(3);


        Optional<ParkingPremise> optionalPremise=Optional.of(premise);

        when(premiseRepository.findById(1)).thenReturn(optionalPremise);
        ParkingPremise myPremise=  iadminservice.deleteParkingPremise(1);
        verify(premiseRepository,times(1)).deleteById(1);
    }

    @Test
    void updatePremise() {

        ParkingPremise premise = new ParkingPremise();

        Address address = new Address();

        address.setAddressId(1);
        address.setCity("bangalore");
        address.setPin("560043");
        address.setState("karnataka");

        premise.setParkingPremiseId(1);
        premise.setParkingPremiseName("PTY Parking");
        premise.setAddressId(address);
        premise.setNumberOfParkingFloors(2);

        Optional<ParkingPremise> optionalPremise = Optional.of(premise);
        when(premiseRepository.findById(1)).thenReturn(optionalPremise);
        ParkingPremise myPremise = iadminservice.updateParkingPremise(1, premise);
    }
    @Test
    void testAdminLogin() {

        Admin admin = new Admin();
        admin.setUsername("Vaibhav");
        admin.setPassword("123456");

        Optional<Admin> optional = Optional.of(admin);

        when(adminRepository.findByUsernameAndPassword("Vaibhav", "123456")).thenReturn(optional);
        iadminservice.login1("Vaibhav", "123456");

        Admin ad = adminRepository.findByUsernameAndPassword("Vaibhav", "123456").get();
        assertNotNull(ad);
    }
}