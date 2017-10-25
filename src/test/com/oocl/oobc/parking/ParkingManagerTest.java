package com.oocl.oobc.parking;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

public class ParkingManagerTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private ParkingLot initParkingLot(int totalSpace, String parkingLotName, int parkedCar) {
        ParkingLot parkingLot = new ParkingLot(totalSpace, parkingLotName);
        for (int i = 0; i < parkedCar; i++) {
            parkingLot.parkCar(new Car(i + ""));
        }
        return parkingLot;
    }

    @Test
    public void should_park_car_success_by_parking_manager() throws Exception {
        ParkingLot parkingLotA = initParkingLot(16, "A", 0);
        ParkingLot parkingLotB = initParkingLot(16, "B", 0);
        ParkingLot parkingLotC = initParkingLot(16, "C", 0);
        List<ParkingAble> parkingAbles = new ArrayList<>();
        parkingAbles.add(parkingLotA);
        parkingAbles.add(parkingLotB);
        parkingAbles.add(parkingLotC);

        ParkingManager parkingManager = new ParkingManager(parkingAbles);
        Car car = new Car("123");
        Ticket ticket = parkingManager.parkCar(car);
        Assert.assertEquals(car, parkingManager.pickupCar(ticket));
    }

    @Test
    public void should_park_car_success_by_parking_manager_if_has_available_space() throws Exception {
        ParkingLot parkingLotA = initParkingLot(16, "A", 16);
        ParkingLot parkingLotB = initParkingLot(16, "B", 0);
        ParkingLot parkingLotC = initParkingLot(16, "C", 16);
        List<ParkingAble> parkingAbles = new ArrayList<>();
        parkingAbles.add(parkingLotA);
        parkingAbles.add(parkingLotB);
        parkingAbles.add(parkingLotC);

        ParkingManager parkingManager = new ParkingManager(parkingAbles);
        Car car = new Car("123");
        Ticket ticket = parkingManager.parkCar(car);
        Assert.assertEquals(car, parkingManager.pickupCar(ticket));
    }

    @Test
    public void should_throw_exception_when_no_available_space() throws Exception {
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PARKING_NO_SPACE);

        ParkingLot parkingLotA = initParkingLot(16, "A", 16);
        ParkingLot parkingLotB = initParkingLot(16, "B", 16);
        ParkingLot parkingLotC = initParkingLot(16, "C", 16);
        List<ParkingAble> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLotA);
        parkingLotList.add(parkingLotB);
        parkingLotList.add(parkingLotC);
//
        ParkingManager parkingManager = new ParkingManager(parkingLotList);
        Car car = new Car("123");
        parkingManager.parkCar(car);
    }


    @Test
    public void should_pickup_car_success_when_it_in_parking_lot() throws Exception {
        ParkingLot parkingLotA = initParkingLot(16, "A", 16);
        ParkingLot parkingLotB = initParkingLot(16, "B", 16);
        ParkingLot parkingLotC = initParkingLot(16, "C", 16);

        ParkingBoyBase parkingBoy = initParkingBoy(2, 16, 0, "boy");
        ParkingManager parkingManager = initParkingManager(parkingLotA, parkingLotB, parkingLotC, parkingBoy);
        Car car = new Car("123");
        Ticket ticket = parkingManager.parkCar(car);

        Assert.assertEquals(car, parkingManager.pickupCar(ticket));
    }


    @Test
    public void should_throw_exception_when_pickup_a_car_not_in_parkinglot() throws Exception {
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PICKUP_CAR_NOT_FOUND);

        ParkingLot parkingLotA = initParkingLot(16, "A", 16);
        ParkingLot parkingLotB = initParkingLot(16, "B", 16);
        ParkingLot parkingLotC = initParkingLot(16, "C", 16);

        ParkingBoyBase parkingBoy = initParkingBoy(2, 16, 0, "boy");
        ParkingManager parkingManager = initParkingManager(parkingLotA, parkingLotB, parkingLotC, parkingBoy);

        Ticket ticket = new Ticket("A", "123");

        parkingManager.pickupCar(ticket);
    }

    private ParkingManager initParkingManager(ParkingAble... parkingAbles) {
        return new ParkingManager(Arrays.asList(parkingAbles));
    }

    private ParkingBoyBase initParkingBoy(int hasParkingLot, int parkingLotSpace, int parkedCarInEachParkingLot, String parkingBoyName) {
        List<ParkingLot> parkingLots = new ArrayList<>();
        for (int i = 0; i < hasParkingLot; i++) {
            ParkingLot parkingLot = initParkingLot(parkingLotSpace, parkingBoyName + i, parkedCarInEachParkingLot);
            parkingLots.add(parkingLot);
        }
        return new ParkingBoy(parkingLots);
    }
}
