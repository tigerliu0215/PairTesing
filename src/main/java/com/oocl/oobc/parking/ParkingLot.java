package com.oocl.oobc.parking;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int totalSpace;
    private String name;

    private Map<Ticket, Car> cars;

    public ParkingLot(int totalSpace, String name) {
        if(totalSpace <= 0){
            throw new ParkingLotException(Constants.EX_INVALID_TOTAL_SPACE);
        }
        this.totalSpace = totalSpace;
        cars = new HashMap<>();
        this.name = name;
    }

    public Ticket parkCar(Car car) {
        if (this.getAvailableSpace() <= 0) {
            throw new ParkingLotException(Constants.EX_PARKING_NO_SPACE);
        }

        if (null == car.getLicensePlateNumber() || "".equals(car.getLicensePlateNumber())) {
            throw new ParkingLotException(Constants.EX_PARKING_WITHOUT_LICENSE_PLATE);
        }
        Ticket ticket = new Ticket(this.name, car.getLicensePlateNumber());
        cars.put(ticket, car);
        return ticket;
    }

    public Car pickupCar(Ticket ticket) {
        Car car = cars.get(ticket);
        if (car == null) {
            throw new ParkingLotException(Constants.EX_PICKUP_CAR_NOT_FOUND);
        }
        cars.remove(ticket);
        return car;
    }

    public boolean isAbleToPickupCar(Ticket ticket) {
        return cars.containsKey(ticket);
    }

    public int getAvailableSpace() {
        return totalSpace - cars.size();
    }

    protected double getVacancyRate() {
        return this.getAvailableSpace() * 100d / this.totalSpace;
    }
}
