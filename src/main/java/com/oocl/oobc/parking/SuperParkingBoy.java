package com.oocl.oobc.parking;

import java.util.List;

public class SuperParkingBoy extends ParkingBoyBase {
    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parkCar(Car car) {
        ParkingLot maxVacancyRateParkingLot = getMaxVacancyRateParkingLot();
        if (maxVacancyRateParkingLot == null) {
            throw new ParkingLotException(Constants.EX_PARKING_NO_SPACE);
        }
        return maxVacancyRateParkingLot.parkCar(car);
    }

    private ParkingLot getMaxVacancyRateParkingLot() {
        double maxVacancyRate = 0;
        ParkingLot maxVacancyRateParkingLot = null;
        for (ParkingLot parkingLot : this.parkingLotList) {
            double currentVacancyRate = parkingLot.getVacancyRate();
            if (currentVacancyRate > maxVacancyRate) {
                maxVacancyRate = currentVacancyRate;
                maxVacancyRateParkingLot = parkingLot;
            }
        }
        return maxVacancyRateParkingLot;
    }
}
