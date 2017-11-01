package com.oocl.oobc.parking;

import java.util.List;

public class ParkingLotReport {
    List<ParkingLotReportRow> parkingLotReportRowList;
    public ParkingLotReport(List<ParkingLotReportRow> reportRows) {
        this.parkingLotReportRowList = reportRows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingLotReport that = (ParkingLotReport) o;
        if(parkingLotReportRowList == null) return null == that.parkingLotReportRowList;
        if(parkingLotReportRowList.size() != that.parkingLotReportRowList.size()) return false;
        boolean isEquals = true;
        for(int i = 0; i < parkingLotReportRowList.size(); i++){
            isEquals = parkingLotReportRowList.get(i).equals(that.parkingLotReportRowList.get(i));
            if(!isEquals){
                return isEquals;
            }
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return parkingLotReportRowList != null ? parkingLotReportRowList.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String previousRole = "M";
        int tabNum = 0;
        for (ParkingLotReportRow parkingLotReportRow : this.parkingLotReportRowList){
            if(!parkingLotReportRow.getRole().equals(previousRole) && !parkingLotReportRow.getRole().equals("M")){
                tabNum += 1;
            } else if ("M".equals(parkingLotReportRow.getRole())) {
                tabNum = 0;
            }
            if("B".equals(parkingLotReportRow.getRole())){
                tabNum = 1;
            }
            for(int i = 0 ; i < tabNum ; i++) {
                sb.append("\t");
            }
            sb.append(parkingLotReportRow.getRole() + "\t" + parkingLotReportRow.getParkedCars() + "\t" + parkingLotReportRow.getTotalSpace() + "\n");
            previousRole = parkingLotReportRow.getRole();
        }
        return sb.toString();
    }
}
