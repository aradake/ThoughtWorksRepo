package com.barclays;

import java.util.ArrayList;
import java.util.List;

public class ParkingAttendant {
    List<Parking> parkingList = new ArrayList();

    private int parkingIndex;

    public ParkingAttendant(List<Parking> parkings) {
        parkingList=parkings;
        this.parkingIndex = -1;
    }


    public Parking allocateParkingToCar() {
        return parkingList.get(selectParking());

    }

    private int selectParking() throws AllParkingsAreFullException {
        if (areAllParkingsFull())
            throw new AllParkingsAreFullException();

        do{
            parkingIndex = (parkingIndex + 1) % parkingList.size();

        } while (parkingList.get(parkingIndex).isFull());
        return parkingIndex;
    }

    private boolean areAllParkingsFull() {

        for (Parking parking : parkingList) {
            if (!parking.isFull()) {
                return false;
            }
        }
        return true;
    }
}
