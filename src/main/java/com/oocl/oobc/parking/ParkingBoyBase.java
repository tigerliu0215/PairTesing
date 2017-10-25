package com.oocl.oobc.parking;

import java.util.ArrayList;
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

    @Override
    public boolean isAbleToPickupCar(Ticket ticket) {
        for (ParkingLot parkingLot : this.parkingLotList){
            boolean isAbleToPickupCar = parkingLot.isAbleToPickupCar(ticket);
            if(isAbleToPickupCar) {
                return isAbleToPickupCar;
            }
        }
        return false;
    }

    @Override
    public List<ParkingLotReportRow> generateReport() {
        List<ParkingLotReportRow> rows = new ArrayList<>();
        int totalSpace = getTotalSpace();
        ParkingLotReportRow boyRow = new ParkingLotReportRow("B",totalSpace - this.getAvailableSpace(),totalSpace);
        rows.add(boyRow);
        for(ParkingLot parkingLot : parkingLotList){
            rows.addAll(parkingLot.generateReport());
        }
        return rows;
    }

    @Override
    public int getTotalSpace() {
        int totalSpace = 0 ;
        for(ParkingLot parkingLot : parkingLotList){
            totalSpace += parkingLot.getTotalSpace();
        }
        return totalSpace;
    }
}
