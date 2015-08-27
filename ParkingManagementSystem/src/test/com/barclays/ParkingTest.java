package com.barclays;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ParkingTest {
    Parking parking;

    @Test
    public void shouldNotParkIfCarIsAlreadyParked() {
        parking = new Parking(10);
        Car parkedCar = new Car("MH12B1234");
        parking.park(parkedCar);
        Car other = new Car("MH12B1234");
        assertFalse(parking.park(other));
    }

    @Test
    public void shouldNotParkIfCapacityFull() {
        parking = new Parking(1);
        Car first = new Car("MH12B1234");
        parking.park(first);
        Car second = new Car("MH12B1234");
        assertFalse(parking.park(second));
    }

    @Test
    public void shouldParkIfCarIsNotParked() {
        parking = new Parking(10);
        Car other = new Car("MH17B1235");
        assertTrue(parking.park(other));
    }

    @Test
    public void shouldUnparkIfCarIsAlreadyParked() {
        parking = new Parking(10);
        Car parkedCar = new Car("MH12B1234");
        parking.park(parkedCar);
        Car other = new Car("MH12B1234");
        assertEquals(other, parking.unPark(other));
    }

    @Test
    public void shouldNotUnparkIfCarIsAlreadyUnparked() {
        parking = new Parking(10);
        Car parkedCar = new Car("MH12B1234");
        parking.park(parkedCar);
        Car other = new Car("MH12B1234");
        parking.unPark(other);
        assertEquals(null, parking.unPark(other));
    }

    @Test
    public void shouldNotUnparkIfCarIsNotParked() {
        parking = new Parking(10);
        Car other = new Car("MH17B1235");
        assertEquals(null, parking.unPark(other));
    }

    @Test
    public void shouldShowFullIfParkingFull() {
        parking = new Parking(1);
        Car first = new Car("MH12B1234");
        parking.park(first);
        assertEquals("parking full", parking.isFull());
    }

    @Test
    public void shouldShowAvailableIfParkingIsNotFull() {
        parking = new Parking(2);
        Car first = new Car("MH12B1234");
        parking.park(first);
        assertEquals("available", parking.isFull());
    }

    @Test
    public void shouldNotParkIfCarIsNull() {
        parking = new Parking(1);
        assertFalse(parking.park(null));
    }
}