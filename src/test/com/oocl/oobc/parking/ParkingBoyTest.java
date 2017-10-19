package com.oocl.oobc.parking;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoyTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private ParkingBoy createParkingBoy() {
        ParkingLot parkingLotA = new ParkingLot(16, "A");
        ParkingLot parkingLotB = new ParkingLot(16, "B");
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLotA);
        parkingLotList.add(parkingLotB);
        return new ParkingBoy(parkingLotList);
    }

    @Test
    public void should_return_32_when_get_available_space_given_2_parkinglot_16_space() {
        ParkingBoy boy = createParkingBoy();
        Assert.assertEquals(32, boy.getAvailableSpace());
    }

    @Test
    public void should_return_A123_when_parking_123_given_2_parkinglot_16_space() {
        ParkingBoy boy = createParkingBoy();
        Car car = new Car("123");
        Assert.assertEquals("A_123", boy.parkCar(car));
    }

    @Test
    public void should_return_31_when_parking_123_given_2_parkinglot_16_space() {
        ParkingBoy boy = createParkingBoy();
        Car car = new Car("123");
        boy.parkCar(car);
        Assert.assertEquals(31, boy.getAvailableSpace());
    }

    @Test
    public void should_return_13_of_parkinglot_A_when_parking_car123_given_2_parkinglot_16_space_each_has_2_car() {
        ParkingLot parkingLotA = new ParkingLot(16, "A");
        ParkingLot parkingLotB = new ParkingLot(16, "B");

        parkingLotA.parkCar(new Car("1"));
        parkingLotA.parkCar(new Car("2"));

        parkingLotB.parkCar(new Car("3"));
        parkingLotB.parkCar(new Car("4"));

        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLotA);
        parkingLotList.add(parkingLotB);

        ParkingBoy boy = new ParkingBoy(parkingLotList);
        Car car = new Car("123");
        boy.parkCar(car);
        Assert.assertEquals(13, parkingLotA.getAvailableSpace());
    }

    @Test
    public void should_throw_exception_when_parking_car123_given_2_parkinglot_16_space_each_has_16_car() {
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PARKING_NO_SPACE);
        ParkingBoy boy = createParkingBoy();
        for (int i = 0; i < 32; i++) {
            boy.parkCar(new Car(i + "1"));
        }
        Car car = new Car("123");
        boy.parkCar(car);
    }

    @Test
    public void should_return_car123_when_pickup_car123_given_car123_in_parkinglot_A() {
        ParkingBoy boy = createParkingBoy();
        Car car = new Car("123");
        boy.parkCar(car);
        Assert.assertEquals(car, boy.pickupCar("A_123"));
    }

    @Test
    public void should_throw_exception_when_pickup_car123_given_car123_in_parkinglot_A() {
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PICKUP_CAR_NOT_FOUND);
        ParkingBoy boy = createParkingBoy();
        Car car = new Car("1");
        boy.parkCar(car);
        boy.pickupCar("A_123");
    }

    @Test
    public void should_throw_exception_when_pickup_car_with_empty_key_given_car123_in_parkinglot_A() {
        expectedEx.expect(ParkingLotException.class);
        expectedEx.expectMessage(Constants.EX_PICKUP_INVALID_KEY);
        ParkingBoy boy = createParkingBoy();
        Car car = new Car("123");
        boy.parkCar(car);
        boy.pickupCar("");
    }
}
