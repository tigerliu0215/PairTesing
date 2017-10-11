package com.oocl.oobc.parking;

import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public int getAvailableSpace() {
        int availableSpace = 0;
        for(ParkingLot parkingLot : parkingLotList){
            availableSpace += parkingLot.getAvailableSpace();
        }
        return availableSpace;
    }

    public String parkingCar(Car car) {
        for(ParkingLot parkingLot : parkingLotList){
            if(parkingLot.getAvailableSpace() > 0){
                return parkingLot.parkCar(car);
            }
        }
        throw new ParkingLotException(Constants.EX_PARKING_NO_SPACE);
    }

    public Car pickupCar(String key) {
        if(key == null || "".equals(key)){
            throw new ParkingLotException(Constants.EX_PICKUP_INVALID_KEY);
        }
        for(ParkingLot parkingLot : parkingLotList){
            try {
                return parkingLot.pickupCar(key);
            } catch (ParkingLotException e) {

            }
        }
        throw new ParkingLotException(Constants.EX_PICKUP_CAR_NOT_FOUND);
    }
}
