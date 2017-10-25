package com.oocl.oobc.parking;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ParkingDirectorTest {

    @Test
    public void should_print_success_when_has_1_manager() throws Exception {
        ParkingLot parkingLotA = initParkingLot(16, "A", 2);
        ParkingBoyBase parkingBoy = initParkingBoy(1,16,3,"boy_A");
        ParkingManager parkingManager = initParkingManager(parkingLotA, parkingBoy);
        List<ParkingManager> parkingManagerList = new ArrayList<>();
        parkingManagerList.add(parkingManager);
        ParkingDirector parkingDirector = new ParkingDirector(parkingManagerList);

        ParkingLotReport report = initParkingLotReport(new Object[][]{
                {"M",5,32},
                    {"P",2,16},
                    {"B",3,16},
                        {"P",3,16}});
        Assert.assertEquals(report,parkingDirector.generateReport());
    }

    @Test
    public void should_print_success_when_has_2_manager() throws Exception {
        ParkingLot parkingLotA = initParkingLot(16, "A", 2);
        ParkingLot parkingLotB = initParkingLot(16, "B", 2);
        ParkingBoyBase parkingBoy1 = initParkingBoy(2,16,3,"boy_A");
        ParkingBoyBase parkingBoy2 = initParkingBoy(2,16,3,"boy_B");
        ParkingManager parkingManager1 = initParkingManager(parkingLotA,parkingLotB, parkingBoy1,parkingBoy2);


        ParkingLot parkingLotC = initParkingLot(16, "C", 2);
        ParkingLot parkingLotD = initParkingLot(16, "D", 2);
        ParkingBoyBase parkingBoy3 = initParkingBoy(2,16,3,"boy_C");
        ParkingBoyBase parkingBoy4 = initParkingBoy(2,16,3,"boy_D");
        ParkingManager parkingManager2 = initParkingManager(parkingLotC,parkingLotD, parkingBoy3,parkingBoy4);

        List<ParkingManager> parkingManagerList = new ArrayList<>();
        parkingManagerList.add(parkingManager1);
        parkingManagerList.add(parkingManager2);
        ParkingDirector parkingDirector = new ParkingDirector(parkingManagerList);

        ParkingLotReport report = initParkingLotReport(new Object[][]{
                {"M",16,96},
                    {"P",2,16},
                    {"P",2,16},
                    {"B",6,32},
                        {"P",3,16},
                        {"P",3,16},
                    {"B",6,32},
                        {"P",3,16},
                        {"P",3,16},
                {"M",16,96},
                    {"P",2,16},
                    {"P",2,16},
                    {"B",6,32},
                        {"P",3,16},
                        {"P",3,16},
                    {"B",6,32},
                        {"P",3,16},
                        {"P",3,16}});
        Assert.assertEquals(report,parkingDirector.generateReport());
    }

    @Test
    public void should_print_the_right_format() throws Exception {
        ParkingLotReport report = initParkingLotReport(new Object[][]{
                {"M",16,96},
                    {"P",2,16},
                    {"P",2,16},
                    {"B",6,32},
                        {"P",3,16},
                        {"P",3,16},
                    {"B",6,32},
                        {"P",3,16},
                        {"P",3,16},
                {"M",16,96},
                    {"P",2,16},
                    {"P",2,16},
                    {"B",6,32},
                        {"P",3,16},
                        {"P",3,16},
                    {"B",6,32},
                        {"P",3,16},
                        {"P",3,16}});
        String printFormat = "";
    }

    private ParkingLotReport initParkingLotReport(Object[][] reportParams) {
        List<ParkingLotReportRow> reportRows = new ArrayList<>();
        for(Object[] rowObject : reportParams){
            String role = rowObject[0].toString();
            int parkedCars = (int)rowObject[1];
            int totalSpace = (int)rowObject[2];
            ParkingLotReportRow row = new ParkingLotReportRow(role,parkedCars,totalSpace);
            reportRows.add(row);
        }
        return new ParkingLotReport(reportRows);
    }


    private ParkingLot initParkingLot(int totalSpace, String parkingLotName, int parkedCar) {
        ParkingLot parkingLot = new ParkingLot(totalSpace, parkingLotName);
        for(int i = 0; i < parkedCar; i++){
            parkingLot.parkCar(new Car(i + ""));
        }
        return parkingLot;
    }

    private ParkingManager initParkingManager(ParkingAble... parkingAbles) {
        return new ParkingManager(Arrays.asList(parkingAbles));
    }

    private ParkingBoyBase initParkingBoy(int hasParkingLot, int parkingLotSpace, int parkedCarInEachParkingLot, String parkingBoyName) {
        List<ParkingLot> parkingLots = new ArrayList<>();
        for (int i = 0; i < hasParkingLot; i++) {
            ParkingLot parkingLot = initParkingLot(parkingLotSpace, parkingBoyName + i, parkedCarInEachParkingLot);
            parkingLots.add(parkingLot);
        }
        return new ParkingBoy(parkingLots);
    }
}
