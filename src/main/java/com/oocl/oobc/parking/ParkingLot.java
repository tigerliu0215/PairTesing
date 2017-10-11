package com.oocl.oobc.parking;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int availableSpace;
    private String name;

    private Map<String, Car> cars;

    public ParkingLot(int totalSpace, String name) {
        this.availableSpace = totalSpace;
        cars = new HashMap<>();
        this.name = name;
    }

    public String parkCar(Car car) {
        if(availableSpace <= 0 ){
            throw new ParkingLotException(Constants.EX_PARKING_NO_SPACE);
        }

        if(null == car.getLicensePlateNumber() || "".equals(car.getLicensePlateNumber())) {
            throw new ParkingLotException(Constants.EX_PARKING_WITHOUT_LICENSE_PLATE);
        }

        cars.put(this.name + "_" + car.getLicensePlateNumber(),car);
        this.availableSpace --;
        return this.name + "_" + car.getLicensePlateNumber();
    }

    public Car pickupCar(String key) {
          Car car = cars.get(key);
          if(car == null ){
              throw new ParkingLotException(Constants.EX_PICKUP_CAR_NOT_FOUND);
          }
          cars.remove(key);
          availableSpace ++;
          return car;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }
}
