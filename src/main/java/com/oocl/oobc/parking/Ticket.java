package com.oocl.oobc.parking;

public class Ticket {
    private String parkingLotName;
    private String carLicensePlateNumber;

    public Ticket(String parkingLotName, String carLicensePlateNumber) {
        this.parkingLotName = parkingLotName;
        this.carLicensePlateNumber = carLicensePlateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (parkingLotName != null ? !parkingLotName.equals(ticket.parkingLotName) : ticket.parkingLotName != null)
            return false;
        return carLicensePlateNumber != null ? carLicensePlateNumber.equals(ticket.carLicensePlateNumber) : ticket.carLicensePlateNumber == null;
    }

    @Override
    public int hashCode() {
        int result = parkingLotName != null ? parkingLotName.hashCode() : 0;
        result = 31 * result + (carLicensePlateNumber != null ? carLicensePlateNumber.hashCode() : 0);
        return result;
    }
}
