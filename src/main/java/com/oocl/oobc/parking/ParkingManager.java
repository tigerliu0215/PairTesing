package com.oocl.oobc.parking;


import java.util.ArrayList;
import java.util.List;

public class ParkingManager{
    private List<ParkingAble> parkingAbles;

    public ParkingManager(List<ParkingAble> parkingAbles) {
        this.parkingAbles = parkingAbles;
    }

    public Ticket parkCar(Car car) {
        for (ParkingAble parkingAble : parkingAbles) {
            if (parkingAble.getAvailableSpace() > 0) {
                return parkingAble.parkCar(car);
            }
        }
        throw new ParkingLotException(Constants.EX_PARKING_NO_SPACE);
    }

    public Car pickupCar(Ticket ticket) {
        for (ParkingAble parkingAble : parkingAbles) {
            if (parkingAble.isAbleToPickupCar(ticket)) {
                return parkingAble.pickupCar(ticket);
            }
        }
        throw new ParkingLotException(Constants.EX_PICKUP_CAR_NOT_FOUND);
    }

    public List<ParkingLotReportRow> generateReport() {
        List<ParkingLotReportRow> rows = new ArrayList<>();
        int totalSpace = getTotalSpace();
        int availableSpace = getAvailableSpace();
        ParkingLotReportRow managerRow = new ParkingLotReportRow("M", totalSpace - availableSpace, totalSpace);
        rows.add(managerRow);
        for(ParkingAble parkingAble : parkingAbles){
            rows.addAll(parkingAble.generateReport());
        }
        return rows;
    }

    private int getAvailableSpace() {
        int availableSpace = 0;
        for(ParkingAble parkingAble : parkingAbles){
            availableSpace += parkingAble.getAvailableSpace();
        }
        return availableSpace;
    }

    private int getTotalSpace() {
        int totalSpace = 0;
        for(ParkingAble parkingAble : parkingAbles){
            totalSpace += parkingAble.getTotalSpace();
        }
        return totalSpace;
    }
}
