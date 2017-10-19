package com.oocl.oobc.parking;

public interface ParkingAble {
    Ticket parkCar(Car car);
    Car pickupCar(Ticket ticket);
}
