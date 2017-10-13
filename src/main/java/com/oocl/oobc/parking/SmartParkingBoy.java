package com.oocl.oobc.parking;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public String parkCar(Car car) {
        ParkingLot maxAvailableSpaceParkingLot = getMaxAvailableSpaceParkingLot();
        return maxAvailableSpaceParkingLot.parkCar(car);

    }

    private ParkingLot getMaxAvailableSpaceParkingLot() {
        int maxAvailableSpace = 0;
        ParkingLot maxAvailableSpaceParkingLot = null;
        for (ParkingLot parkingLot : this.parkingLotList){
            if(parkingLot.getAvailableSpace() > maxAvailableSpace){
                maxAvailableSpace = parkingLot.getAvailableSpace();
                maxAvailableSpaceParkingLot = parkingLot;
            }
        }
        return maxAvailableSpaceParkingLot;
    }
}
