package com.barclays;
public class Car {
    private String carNumber;

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Car) {
            Car that = (Car) object;
            return this.carNumber.equals(that.carNumber);
        }
        return false;
    }
}

