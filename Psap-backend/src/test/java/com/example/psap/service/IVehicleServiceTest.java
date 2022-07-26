package com.example.psap.service;

import com.example.psap.dao.Vehicledao;
import com.example.psap.entity.Vehicle;
import com.example.psap.entity.VehicleType;
import com.example.psap.exception.NoSuchVehicleException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@SpringBootTest
class IVehicleServiceTest {

    @InjectMocks
    private IVehicleService ivehicleservice = new VehicleServiceImpl();
    @Mock
    private Vehicledao vehicledao;

    @Test
    public void findvehiclebyvehiclenumber() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(1);
        vehicle.setVehicleType(VehicleType.valueOf("TWO_WHEELER"));
        vehicle.setVehicleNumber("ka12n");
        vehicle.setVehicleCompany("mahindra");
        vehicle.setVehicleModel("2006");
        Optional<Vehicle> optionalVehicle = Optional.of(vehicle);
        when(vehicledao.findByVehicleNumber("ka12n")).thenReturn(optionalVehicle);
        Vehicle myVehicle = ivehicleservice.findVehicleByVehicleNumber("ka12n");
        assertEquals(1, myVehicle.getVehicleId());
    }

    @Test
    void findvehiclebyvehiclenumberexception() {
        when(vehicledao.findById(5)).thenThrow(NoSuchVehicleException.class);
        assertThrows(NoSuchVehicleException.class, () -> ivehicleservice.findVehicleByVehicleNumber("ka12n"));
    }

    @Test
    void getallvehiclestest() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(1);
        vehicle.setVehicleType(VehicleType.valueOf("TWO_WHEELER"));
        vehicle.setVehicleNumber("ka12n");
        vehicle.setVehicleCompany("mahindra");
        vehicle.setVehicleModel("2006");


        Vehicle vehicle2 = new Vehicle();
        vehicle.setVehicleId(2);
        vehicle.setVehicleType(VehicleType.valueOf("THREE_WHEELER"));
        vehicle.setVehicleNumber("ka13n");
        vehicle.setVehicleCompany("tata");
        vehicle.setVehicleModel("2007");


        Vehicle vehicle3 = new Vehicle();
        vehicle.setVehicleId(3);
        vehicle.setVehicleType(VehicleType.valueOf("FOUR_WHEELER"));
        vehicle.setVehicleNumber("ka14n");
        vehicle.setVehicleCompany("hyundai");
        vehicle.setVehicleModel("2008");


        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(vehicle);
        vehicleList.add(vehicle2);
        vehicleList.add(vehicle3);

        when(vehicledao.findAll()).thenReturn(vehicleList);
        List<Vehicle> vehicles = ivehicleservice.getallvehicles();
        assertEquals(3, vehicles.size());
    }

    @Test
    void removeVehicleByVehicleNumbertest() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(1);
        vehicle.setVehicleType(VehicleType.valueOf("TWO_WHEELER"));
        vehicle.setVehicleCompany("mahindra");
        vehicle.setVehicleModel("2006");
        vehicle.setVehicleNumber("ka12n");
        Optional<Vehicle> optionalVehicle = Optional.of(vehicle);
        when(vehicledao.findByVehicleNumber("ka12n")).thenReturn(optionalVehicle);
        Vehicle myVehicle = ivehicleservice.removeVehicleByVehicleNumber("ka12n");
        verify(vehicledao, times(1)).deleteByVehicleNumber("ka12n");

    }

    @Test
    void getVehicleById() throws NoSuchVehicleException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(1);
        vehicle.setVehicleType(VehicleType.valueOf("TWO_WHEELER"));
        vehicle.setVehicleCompany("mahindra nexon");
        vehicle.setVehicleModel("2007");
        vehicle.setVehicleNumber("ka123n");
        Optional<Vehicle> optionalVehicle = Optional.of(vehicle);
        when(vehicledao.findById(1)).thenReturn(optionalVehicle);
        Vehicle myvehicle;
        myvehicle = ivehicleservice.fetchVehicleByVehicleId(1);
        assertEquals(1, myvehicle.getVehicleId());

    }

    @Test
    void removeVehicleByVehicleNumbertestexception() {
        when(vehicledao.findById(1)).thenThrow(NoSuchVehicleException.class);
        assertThrows(NoSuchVehicleException.class, () -> ivehicleservice.removeVehicleByVehicleNumber("ka123n"));
    }

    @Test
    void updateVehicle() {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(1);
        vehicle.setVehicleType(VehicleType.valueOf("TWO_WHEELER"));
        vehicle.setVehicleCompany("mahindra nexon");
        vehicle.setVehicleModel("2007");
        vehicle.setVehicleNumber("ka123n");

        Optional<Vehicle> optionalVehicle = Optional.of(vehicle);
        when(vehicledao.findById(1)).thenReturn(optionalVehicle);
        Vehicle myVehicle = ivehicleservice.updateVehicle(1, vehicle);

    }


}