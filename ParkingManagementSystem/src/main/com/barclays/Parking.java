package com.barclays;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private int capacity;
    List<Car> parkingLot = new ArrayList();

    List<ParkingObserver> observers = new ArrayList();
    ParkingOwner parkingOwner;
    public void registerObserver(ParkingObserver parkingObserver) {
        observers.add(parkingObserver);
    }
    public void registerOwner(ParkingOwner owner)
    {
        parkingOwner=owner;
        observers.add(parkingOwner);
    }

    public Parking(int capacity) {
        this.capacity = capacity;
    }

    private boolean isAlreadyParked(Car car) {
        return parkingLot.contains(car);
    }

    public boolean park(Car car) {
        if (car != null){
            if (!isFull()) {
                if (isAlreadyParked(car))
                    return false;
                else {
                    parkingLot.add(car);
                    //Notify All Observers
                    if (isFull())
                        notifyObserversThatParkingIsFull();

                    return true;
                }
            }
        }
        return false;
    }

    private void notifyObserversThatParkingIsFull() {
        observers.forEach(ParkingObserver::parkingFullNotification);
    }

    private void notifyOwnerThatParkingIsAvailable() {
      parkingOwner.parkingAvailableNotification();
    }

    public Car unPark(Car car) {
        if (isAlreadyParked(car)) {
            if (isFull())
                notifyOwnerThatParkingIsAvailable();

            return parkingLot.remove(parkingLot.indexOf(car));
        }
        return null;
    }

    public boolean isFull() {
        if (parkingLot.size() >= this.capacity)
            return true;
        return false;
    }
}
