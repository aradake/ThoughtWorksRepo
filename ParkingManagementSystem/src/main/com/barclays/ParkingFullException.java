package com.barclays;

public class ParkingFullException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Parking Capacity Full";
    }
}
