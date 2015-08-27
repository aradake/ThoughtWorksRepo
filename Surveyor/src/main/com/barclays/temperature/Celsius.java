package com.barclays.temperature;

public class Celsius implements Temperature {

    private double temperature;

    public Celsius(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double toKelvin() {
        return temperature + 273.15;
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
