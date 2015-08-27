package com.barclays;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
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

    ParkingOwner mockOwner;
    ParkingSecurity mockSecurity;

    @Before
    public void setUp() {
        mockOwner = mock(ParkingOwner.class);
        mockSecurity = mock(ParkingSecurity.class);
    }

    @Test
    public void shouldNotifyIfParkingIsFull() {
        parking = new Parking(1);
        parking.registerOwner(mockOwner);
        parking.registerObserver(mockSecurity);
        Car first = new Car("MH12B1234");
        parking.park(first);
        verify(mockOwner, times(1)).parkingFullNotification();
        verify(mockSecurity, times(1)).parkingFullNotification();

    }

    @Test
    public void shouldNotifyOwnerIfParkingIsAvailable() {
        parking = new Parking(1);
        Car first = new Car("MH12B1234");
        parking.registerOwner(mockOwner);
        parking.park(first);
        parking.unPark(first);
        verify(mockOwner, times(1)).parkingAvailableNotification();

    }

    @Test
    public void shouldNotParkIfCarIsNull() {
        parking = new Parking(1);
        assertFalse(parking.park(null));
    }

}