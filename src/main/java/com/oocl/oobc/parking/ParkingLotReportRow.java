package com.oocl.oobc.parking;

public class ParkingLotReportRow {
    private String role;
    private int parkedCars;
    private int totalSpace;
    public ParkingLotReportRow(String role, int parkedCars, int totalSpace) {
        this.role = role;
        this.parkedCars = parkedCars;
        this.totalSpace = totalSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingLotReportRow that = (ParkingLotReportRow) o;

        if (parkedCars != that.parkedCars) return false;
        if (totalSpace != that.totalSpace) return false;
        return role != null ? role.equals(that.role) : that.role == null;
    }

    @Override
    public int hashCode() {
        int result = role != null ? role.hashCode() : 0;
        result = 31 * result + parkedCars;
        result = 31 * result + totalSpace;
        return result;
    }
}
