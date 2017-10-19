package com.oocl.oobc.parking;

import java.util.List;

import static com.oocl.oobc.parking.Constants.EX_PARKING_NO_SPACE;

public class ParkingBoy extends ParkingBoyBase{

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Ticket parkCar(Car car) {
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
}
