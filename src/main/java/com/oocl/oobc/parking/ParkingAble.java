package com.oocl.oobc.parking;

import java.util.List;

public interface ParkingAble {
    Ticket parkCar(Car car);
    Car pickupCar(Ticket ticket);
    boolean isAbleToPickupCar(Ticket ticket);
    int getAvailableSpace();
    int getTotalSpace();
    List<ParkingLotReportRow> generateReport();
}
