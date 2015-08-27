package com.barclays;

public class CarIsNotPresent extends RuntimeException {
    @Override
    public String getMessage() {
        return "Car is not present";
    }
}
