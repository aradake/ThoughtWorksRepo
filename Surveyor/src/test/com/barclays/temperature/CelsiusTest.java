package com.barclays.temperature;

import org.junit.Test;

import static org.junit.Assert.*;

public class CelsiusTest {
    @Test
    public void shouldBeTwoCelsiusEqual() {
        Temperature first = new Celsius(20);
        Temperature second = new Celsius(20);
        assertEquals(first, second);
    }

    @Test
    public void shouldBeCelsiusAndFahrenheitEqual() {
        Temperature celsius = new Celsius(0);
        Temperature fahrenheit = new Fahrenheit(32);
        assertEquals(celsius, fahrenheit);
    }

    @Test
    public void shouldBeCelsiusAndKelvinEqual() {
        Temperature celsius = new Celsius(0);
        Temperature kelvin = new Kelvin(273.15);
        assertEquals(celsius, kelvin);
    }


}