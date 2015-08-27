package com.barclays;

import java.util.ArrayList;
import java.util.List;

public class ParkingOwner implements ParkingObserver {

    List<Parking> parkingList = new ArrayList();

    @Override
    public void parkingFullNotification() {

    }
    @Override
    public void parkingAvailableNotification() {

    }

    public void addNewParking(Parking parking) {
        parkingList.add(parking);
    }

    public ParkingAttendant appointParkingAttendant() {
        ParkingAttendant attendant = new ParkingAttendant();
        return attendant;
    }

    public List<Parking> getParkingList() {
        return parkingList;
    }
}
