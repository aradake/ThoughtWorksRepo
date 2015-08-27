package com.barclays.temperature;

public class Fahrenheit implements Temperature {

    private double temperature;

    public Fahrenheit(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double toKelvin(){

        return (temperature - 32) * 5 / 9 + 273.15;
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
