package com.barclays;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParkingAttendantTest {
    List<Parking> parkingList;
    Parking first;
    Parking second;
    Parking third;

    @Before
    public void setUp() {
        first = new Parking(1);
        second = new Parking(1);
        third = new Parking(1);
        parkingList = new ArrayList();
        parkingList.add(first);
        parkingList.add(second);
        parkingList.add(third);
    }

    @Test
    public void shouldAllocateParkingToCarIfAvailable() {
        ParkingAttendant attendant = new ParkingAttendant(parkingList);
        attendant.allocateParkingToCar();
        Parking parking = attendant.allocateParkingToCar();
        assertEquals(second, parking);

    }

    @Test(expected = AllParkingsAreFullException.class)
    public void shouldNotAllocateParkingToCarIfNotAvailable() {
        ParkingAttendant attendant = new ParkingAttendant(parkingList);
        attendant.allocateParkingToCar().park(new Car("MH10F1483"));
        attendant.allocateParkingToCar().park(new Car("MH10F1483"));
        attendant.allocateParkingToCar().park(new Car("MH10F1483"));
        attendant.allocateParkingToCar();
    }

}