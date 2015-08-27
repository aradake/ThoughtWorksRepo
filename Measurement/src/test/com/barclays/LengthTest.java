package com.barclays;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthTest {

    @Test
    public void shouldAddLength() {

        Length first = new Length(5, 50);
        Length second = new Length(10, 40);
        Length result = first.add(second);
        assertEquals(15, result.getMeters());
        assertEquals(90, result.getCentimeters());
    }

    @Test
    public void shouldBeTrueIfLengthsAreEqual() {
        Length first = new Length(5, 60);
        Length second = new Length(5, 50);
        assertEquals(first,second);
    }
}