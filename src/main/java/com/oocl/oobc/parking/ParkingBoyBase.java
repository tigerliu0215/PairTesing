package com.oocl.oobc.parking;

import java.util.List;

public abstract class ParkingBoyBase implements ParkingAble{
    protected List<ParkingLot> parkingLotList;

    public ParkingBoyBase(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public int getAvailableSpace() {
        int availableSpace = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            availableSpace += parkingLot.getAvailableSpace();
        }
        return availableSpace;
    }

    public Car pickupCar(Ticket ticket) {
        if (ticket == null ) {
            throw new ParkingLotException(Constants.EX_PICKUP_INVALID_KEY);
        }

        ParkingLot carInParkingLot = findParkingLotByCar(ticket);
        if (carInParkingLot == null) {
            throw new ParkingLotException(Constants.EX_PICKUP_CAR_NOT_FOUND);
        }
        return carInParkingLot.pickupCar(ticket);
    }

    private ParkingLot findParkingLotByCar(Ticket ticket) {
        ParkingLot carInParkingLot = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.isAbleToPickupCar(ticket)) {
                carInParkingLot = parkingLot;
            }
        }
        return carInParkingLot;
    }
}
