package com.oocl.oobc.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingDirector {

    private List<ParkingManager> parkingManagerList;
    public ParkingDirector(List<ParkingManager> parkingManagerList) {
        this.parkingManagerList = parkingManagerList;
    }

    public ParkingLotReport generateReport() {
        List<ParkingLotReportRow> rows = new ArrayList<>();
        for(ParkingManager parkingManager : this.parkingManagerList){
            rows.addAll(parkingManager.generateReport());
        }
        return new ParkingLotReport(rows);
    }
}
