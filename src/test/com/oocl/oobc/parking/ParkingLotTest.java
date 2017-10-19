package com.oocl.oobc.parking;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingLotTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void should_throw_exception_when_totalspace_less_or_equal_0() throws Exception {
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_INVALID_TOTAL_SPACE);
        ParkingLot parkingLot = new ParkingLot(0, "A");
    }

    @Test
    public void should_return_key123_when_no_car_parking() {
        ParkingLot parkingLot = new ParkingLot(16, "A");
        Car car = new Car("123");
        Ticket ticket = new Ticket("A", "123") ;
        Assert.assertEquals(ticket, parkingLot.parkCar(car));
    }

    @Test
    public void should_return_15_when_1_car_parking() {
        ParkingLot parkingLot = new ParkingLot(16, "A");
        Car car = new Car("123");
        parkingLot.parkCar(car);

        Assert.assertEquals(15, parkingLot.getAvailableSpace());
    }

    @Test
    public void should_return_exception_when_1_car_into_given_16_car_parking() {
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PARKING_NO_SPACE);
        ParkingLot parkingLot = new ParkingLot(16, "A");
        for (int i = 0; i < 16; i++) {
            parkingLot.parkCar(new Car("123_" + i));
        }
        Car car = new Car("123");
        parkingLot.parkCar(car);
    }

    @Test
    public void should_return_car123_when_pick_up_1_car_given_car123_in_parkinglot() {
        ParkingLot parkingLot = new ParkingLot(16, "A");
        Car car = new Car("123");
        parkingLot.parkCar(car);

        Assert.assertEquals(car, parkingLot.pickupCar(new Ticket("A","123")));
    }

    @Test
    public void should_return_16_when_pick_up_car123_given_car123_in_parkinglot() {
        ParkingLot parkingLot = new ParkingLot(16, "A");
        Car car = new Car("123");
        parkingLot.parkCar(car);
        parkingLot.pickupCar(new Ticket("A","123"));
        Assert.assertEquals(16, parkingLot.getAvailableSpace());
    }

    @Test
    public void should_return_exception_when_park_car_withoutkey_given_no_car_in_parkinglot() {
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PARKING_WITHOUT_LICENSE_PLATE);
        ParkingLot parkingLot = new ParkingLot(16, "A");
        Car car = new Car("");
        parkingLot.parkCar(car);
    }

    @Test
    public void should_return_exception_when_pickup_car123_given_no_car_in_parkinglot() {
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PICKUP_CAR_NOT_FOUND);
        ParkingLot parkingLot = new ParkingLot(16, "A");
        parkingLot.pickupCar(new Ticket("A","123"));
    }

    @Test
    public void should_return_exception_when_pickup_car123_given_2_car_in_parkinglot() {
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PICKUP_CAR_NOT_FOUND);
        ParkingLot parkingLot = new ParkingLot(16, "A");
        parkingLot.parkCar(new Car("111"));
        parkingLot.parkCar(new Car("222"));
        parkingLot.pickupCar(new Ticket("A","123"));
    }

}
