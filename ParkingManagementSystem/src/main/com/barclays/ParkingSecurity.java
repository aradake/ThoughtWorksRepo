package com.barclays;

public class ParkingSecurity implements ParkingObserver {

    @Override
    public String parkingFullNotification() {
        return "Work Security";
    }
}
