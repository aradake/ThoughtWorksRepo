package com.barclays;

import java.util.ArrayList;
import java.util.List;

public class ParkingAttendant {
    List<Parking> parkingList = new ArrayList();

    private int parkingIndex;

    public ParkingAttendant() {
        this.parkingIndex = -1;
    }

    public void assignParkingLots(List<Parking> parkings) {
        parkingList = parkings;
    }


    public Parking allocateParkingToCar() {
        return parkingList.get(selectParking());

    }

    private int selectParking() {
        parkingIndex = (parkingIndex + 1) % parkingList.size();
        return parkingIndex;
    }
}
