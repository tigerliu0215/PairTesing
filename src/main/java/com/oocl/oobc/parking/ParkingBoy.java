package com.oocl.oobc.parking;

import java.util.List;

import static com.oocl.oobc.parking.Constants.EX_PARKING_NO_SPACE;

public class ParkingBoy {

    protected List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public int getAvailableSpace() {
        int availableSpace = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            availableSpace += parkingLot.getAvailableSpace();
        }
        return availableSpace;
    }

    public String parkCar(Car car) {
        if (getAvailableSpace() <= 0) {
            throw new ParkingLotException(EX_PARKING_NO_SPACE);
        }
        ParkingLot firstAvailableParkingLot = getFirstAvailableParkingLot();
        return firstAvailableParkingLot.parkCar(car);
    }

    private ParkingLot getFirstAvailableParkingLot() {
        ParkingLot firstAvailableParkingLot = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getAvailableSpace() > 0) {
                firstAvailableParkingLot = parkingLot;
                break;
            }
        }
        return firstAvailableParkingLot;
    }

    public Car pickupCar(String key) {
        if (key == null || "".equals(key)) {
            throw new ParkingLotException(Constants.EX_PICKUP_INVALID_KEY);
        }

        ParkingLot carInParkingLot = findParkingLotByCar(key);
        if (carInParkingLot == null) {
            throw new ParkingLotException(Constants.EX_PICKUP_CAR_NOT_FOUND);
        }
        return carInParkingLot.pickupCar(key);
    }

    private ParkingLot findParkingLotByCar(String key) {
        ParkingLot carInParkingLot = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.isAbleToPickupCar(key)) {
                carInParkingLot = parkingLot;
            }
        }
        return carInParkingLot;
    }
}
