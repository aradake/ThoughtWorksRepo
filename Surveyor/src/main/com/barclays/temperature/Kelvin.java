package com.barclays.temperature;

public class Kelvin implements Temperature {

    private double temperature;

    public Kelvin(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double toKelvin() {
        return temperature;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Temperature) {
            Temperature that = (Temperature) object;
            if (this.toKelvin() == that.toKelvin()) {
                return true;
            }
        }
        return false;
    }
}
