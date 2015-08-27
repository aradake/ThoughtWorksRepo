package com.barclays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parking {
    private int capacity;
    static int currentTokenNumber = 1;
    private HashMap<Token, Car> parkingLot = new HashMap();

    List<ParkingObserver> observers = new ArrayList();
    ParkingOwner parkingOwner;

    public void registerObserver(ParkingObserver parkingObserver) {
        observers.add(parkingObserver);
    }

    public void registerOwner(ParkingOwner owner) {
        parkingOwner = owner;
        observers.add(parkingOwner);
    }

    public Parking(int capacity) {
        this.capacity = capacity;
    }

    private boolean isAlreadyParked(Car car) {
        return parkingLot.containsValue(car);
    }

    public Token park(Car car) {

            if (!isFull()) {
                if (isAlreadyParked(car)) {
                    throw new CarIsAlreadyParkedException();

                } else {
                    Token token = generateToken();
                    parkingLot.put(token, car);
                    //Notify All Observers
                    if (isFull())
                        notifyObserversThatParkingIsFull();

                    return token;
                }

            } else
               throw new ParkingFullException();

    }

    private void notifyObserversThatParkingIsFull() {
        observers.forEach(ParkingObserver::parkingFullNotification);
    }

    private void notifyOwnerThatParkingIsAvailable() {
        parkingOwner.parkingAvailableNotification();
    }

    public Car unPark(Token token) {
        if (isTokenPresent(token)) {
            if (isFull())
                notifyOwnerThatParkingIsAvailable();
            return parkingLot.remove(token);
        }
        else
          throw new CarIsNotPresent();
    }

    public boolean isTokenPresent(Token token) {
        return parkingLot.containsKey(token);
    }

    public boolean isFull() {
        if (parkingLot.size() >= this.capacity)
            return true;
        return false;
    }

    public Token generateToken() {
        return new Token(currentTokenNumber++);
    }
}
