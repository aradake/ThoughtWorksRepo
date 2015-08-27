package com.barclays;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ParkingTest {
    Parking parking;

    ParkingOwner mockOwner;
    ParkingSecurity mockSecurity;

    Token mockToken;

    @Before
    public void setUp() {
        mockOwner = mock(ParkingOwner.class);
        mockSecurity = mock(ParkingSecurity.class);
        mockToken = mock(Token.class);


    }

    @Test(expected = CarIsAlreadyParkedException.class)
    public void shouldNotParkIfCarIsAlreadyParked() {
        parking = new Parking(10);
        Car parkedCar = new Car("MH12B1234");
        parking.park(parkedCar);
        Car other = new Car("MH12B1234");
        parking.park(other);
    }


    @Test(expected = ParkingFullException.class)
    public void shouldNotParkIfCapacityFull() {
        parking = new Parking(1);
        Car first = new Car("MH12B1234");
        parking.park(first);
        Car second = new Car("MH12B1236");
        parking.park(second);
    }

    /*@Test
    public void shouldParkIfCarIsNotParked() {
        parking = new Parking(10);
        Car other = new Car("MH17B1235");
        assertNotNull(parking.park(other));
       
    }
*/

    @Test
    public void shouldUnparkIfCarIsAlreadyParked() {
        parking = new Parking(10);
        Car parkedCar = new Car("MH12B1234");
        Token token = parking.park(parkedCar);
        Car outCar = parking.unPark(token);

        assertEquals(parkedCar, outCar);
    }

    @Test(expected = CarIsNotPresent.class)
    public void shouldNotUnparkIfCarIsNotPresent() {
        parking = new Parking(10);
        Car parkedCar = new Car("MH12B1234");
        parking.park(parkedCar);
        Token dummy = new Token(-50);
        parking.unPark(dummy);

    }

    @Test(expected = CarIsNotPresent.class)
    public void shouldNotUnparkIfCarIsAlreadyUnparked() {
        parking = new Parking(10);
        Car parkedCar = new Car("MH12B1234");
        Token token = parking.park(parkedCar);
        parking.unPark(token);
        parking.unPark(token);

    }


    @Test
    public void shouldNotifyOwnerIfParkingIsFull() {
        parking = new Parking(1);
        parking.registerOwner(mockOwner);
        Car first = new Car("MH12B1234");
        parking.park(first);
        verify(mockOwner, times(1)).parkingFullNotification();


    }

    @Test
    public void shouldNotifySecurityIfParkingIsFull() {
        parking = new Parking(1);
        parking.registerObserver(mockSecurity);
        Car first = new Car("MH12B1234");
        parking.park(first);
        verify(mockSecurity, times(1)).parkingFullNotification();

    }

    @Test
    public void shouldNotifyOwnerIfParkingIsAvailable() {
        parking = new Parking(1);
        Car first = new Car("MH12B1234");
        parking.registerOwner(mockOwner);
        Token token=parking.park(first);
        parking.unPark(token);
        verify(mockOwner, times(1)).parkingAvailableNotification();

    }



}