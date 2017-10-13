package com.oocl.oobc.parking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoyTest {

    @Test
    public void should_parking_car_in_a_parkinglot_has_more_available_space(){
        ParkingLot parkingLotA = new ParkingLot(16,"A");
        ParkingLot parkingLotB = new ParkingLot(16,"B");
        parkingLotA.parkCar(new Car("a1"));
        parkingLotA.parkCar(new Car("a2"));
        parkingLotB.parkCar(new Car("b1"));
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLotA);
        parkingLotList.add(parkingLotB);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        Car car = new Car("123");
        smartParkingBoy.parkCar(car);

        Assert.assertEquals(car,parkingLotB.pickupCar("B_123"));
    }

    @Test
    public void should_parking_car_success_when_all_parking_lot_has_same_available_space(){
        ParkingLot parkingLotA = new ParkingLot(16,"A");
        ParkingLot parkingLotB = new ParkingLot(16,"B");
        parkingLotA.parkCar(new Car("a1"));
        parkingLotA.parkCar(new Car("a2"));
        parkingLotB.parkCar(new Car("b1"));
        parkingLotB.parkCar(new Car("b2"));
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLotA);
        parkingLotList.add(parkingLotB);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        Car car = new Car("123");
        smartParkingBoy.parkCar(car);

        Assert.assertEquals(car,smartParkingBoy.pickupCar("A_123"));
    }


}
