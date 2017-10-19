package com.oocl.oobc.parking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingManagerTest {

    private ParkingLot initParkingLot(int totalSpace, String parkingLotName, int parkedCar) {
        ParkingLot parkingLot = new ParkingLot(totalSpace, parkingLotName);
        for(int i = 0; i < parkedCar; i++){
            parkingLot.parkCar(new Car(i + ""));
        }
        return parkingLot;
    }

    @Test
    public void should_park_car_success_by_parking_manager() throws Exception {
        ParkingLot parkingLotA = initParkingLot(16, "A", 0);
        ParkingLot parkingLotB = initParkingLot(16, "B", 0);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLotA);
        parkingLotList.add(parkingLotB);
        ParkingManager parkingManager = new ParkingManager(parkingLotList);
        Car car = new Car("123");
        Ticket ticket = parkingManager.parkCar(car);
        Assert.assertEquals(car, parkingManager.pickupCar(ticket));
    }
}
