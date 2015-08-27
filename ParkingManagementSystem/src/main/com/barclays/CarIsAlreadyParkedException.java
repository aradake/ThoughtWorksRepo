package com.barclays;

public class CarIsAlreadyParkedException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Car is Already Parked";
    }
}
