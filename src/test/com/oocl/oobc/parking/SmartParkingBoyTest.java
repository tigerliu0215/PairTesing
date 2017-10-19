package com.oocl.oobc.parking;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

public class SmartParkingBoyTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private ParkingLot initParkingLot(int totalSpace, String parkingLotName, int parkedCar) {
        ParkingLot parkingLot = new ParkingLot(totalSpace, parkingLotName);
        for(int i = 0; i < parkedCar; i++){
            parkingLot.parkCar(new Car(i + ""));
        }
        return parkingLot;
    }


    private SmartParkingBoy initSmartParkingBoy(ParkingLot ... parkingLots) {
        SmartParkingBoy smartParkingBoy;
        smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLots));
        return smartParkingBoy;
    }

    @Test
    public void should_parking_car_in_a_parkinglot_has_more_available_space(){
        ParkingLot parkingLotA = initParkingLot(16,"A",2);
        ParkingLot parkingLotB = initParkingLot(16,"B",1);

        SmartParkingBoy smartParkingBoy = initSmartParkingBoy(parkingLotA,parkingLotB);
        Car car = new Car("123");
        smartParkingBoy.parkCar(car);

        Assert.assertEquals(car,parkingLotB.pickupCar("B_123"));
    }

    @Test
    public void should_throw_exception_when_no_available_space(){
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PARKING_NO_SPACE);

        ParkingLot parkingLotA = initParkingLot(16,"A",16);
        ParkingLot parkingLotB = initParkingLot(16,"B",16);

        SmartParkingBoy smartParkingBoy = initSmartParkingBoy(parkingLotA,parkingLotB);
        Car car = new Car("123");
        smartParkingBoy.parkCar(car);
    }

    @Test
    public void should_pickup_a_car_when_it_in_the_parkinglot(){
        ParkingLot parkingLotA = initParkingLot(16,"A",2);
        ParkingLot parkingLotB = initParkingLot(16,"B",1);

        SmartParkingBoy smartParkingBoy = initSmartParkingBoy(parkingLotA,parkingLotB);
        Car car = new Car("123");
        String key = smartParkingBoy.parkCar(car);

        Assert.assertEquals(car,smartParkingBoy.pickupCar(key));
    }


    @Test
    public void should_throw_exception_when_pickup_a_car_not_in_parkinglot(){
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PICKUP_CAR_NOT_FOUND);

        ParkingLot parkingLotA = initParkingLot(16,"A",16);
        ParkingLot parkingLotB = initParkingLot(16,"B",16);

        SmartParkingBoy smartParkingBoy = initSmartParkingBoy(parkingLotA,parkingLotB);
        smartParkingBoy.pickupCar("B_123");
    }
}
