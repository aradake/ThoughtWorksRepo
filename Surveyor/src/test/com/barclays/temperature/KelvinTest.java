package com.barclays.temperature;

import org.junit.Test;

import static org.junit.Assert.*;

public class KelvinTest {


    @Test
    public void shouldBeTwoKelvinEqual() {
        Temperature first = new Fahrenheit(20);
        Temperature second = new Fahrenheit(20);
        assertEquals(first, second);
    }


    @Test
    public void shouldBeKelvinAndFahrenheitEqual() {
        Temperature kelvin = new Kelvin(273.15);
        Temperature fahrenheit = new Fahrenheit(32);
        assertEquals(kelvin, fahrenheit);
    }

    @Test
    public void shouldBeKelvinAndCelsiusEqual() {
        Temperature celsius = new Celsius(0);
        Temperature kelvin = new Kelvin(273.15);
        assertEquals(kelvin,celsius);
    }

}