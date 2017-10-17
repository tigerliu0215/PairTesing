package com.oocl.oobc.parking;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuperParkingBoyTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Test
    public void should_parkcar_in_max_vacancy_rate_parkinglot() throws Exception {
        SuperParkingBoy superParkingBoy;
        ParkingLot parkingLotA = initParkingLot(16, "A", 8);
        ParkingLot parkingLotB = initParkingLot(10, "B", 2);
        superParkingBoy = initSuperParkingBoy(parkingLotA, parkingLotB);
        Car car = new Car("123");
        String ticket = superParkingBoy.parkCar(car);
        Assert.assertEquals(car, parkingLotB.pickupCar("B_123"));
    }

    @Test
    public void should_throw_exception_when_no_available_space() throws Exception {
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PARKING_NO_SPACE);

        SuperParkingBoy superParkingBoy;
        ParkingLot parkingLotA = initParkingLot(16, "A", 16);
        ParkingLot parkingLotB = initParkingLot(10, "B", 10);
        superParkingBoy = initSuperParkingBoy(parkingLotA, parkingLotB);
        Car car = new Car("123");
        superParkingBoy.parkCar(car);
    }

    @Test
    public void should_pick_up_a_car_success_when_it_in_the_parking_lot() throws Exception {
        SuperParkingBoy superParkingBoy;
        ParkingLot parkingLotA = initParkingLot(16, "A", 0);
        ParkingLot parkingLotB = initParkingLot(10, "B", 0);
        superParkingBoy = initSuperParkingBoy(parkingLotA, parkingLotB);
        Car car = new Car("123");
        String key = superParkingBoy.parkCar(car);
        Assert.assertEquals(car,superParkingBoy.pickupCar(key));
    }


    @Test
    public void should_throw_exception_when_pick_up_a_car_not_in_parkinglot() throws Exception {
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PICKUP_CAR_NOT_FOUND);

        SuperParkingBoy superParkingBoy;
        ParkingLot parkingLotA = initParkingLot(16, "A", 16);
        ParkingLot parkingLotB = initParkingLot(10, "B", 10);
        superParkingBoy = initSuperParkingBoy(parkingLotA, parkingLotB);
        superParkingBoy.pickupCar("B_123");
    }

    private ParkingLot initParkingLot(int totalSpace, String parkingLotName, int parkedCar) {
        ParkingLot parkingLot = new ParkingLot(totalSpace, parkingLotName);
        for(int i = 0; i < parkedCar; i++){
            parkingLot.parkCar(new Car(i + ""));
        }
        return parkingLot;
    }


    private SuperParkingBoy initSuperParkingBoy(ParkingLot ... parkingLots) {
        SuperParkingBoy superParkingBoy;
        superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLots));
        return superParkingBoy;
    }
}
