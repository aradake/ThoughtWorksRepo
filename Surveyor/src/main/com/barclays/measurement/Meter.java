package com.barclays.measurement;

public class Meter implements Unit {
    private double meters;

    @Override
    public double toBase() {
        return 0;
    }
}
