package com.barclays.temperature;

import org.junit.Test;

import static org.junit.Assert.*;

public class FahrenheitTest {

    @Test
    public void shouldBeTwoFahrenheitEqual() {
        Temperature first = new Fahrenheit(20);
        Temperature second = new Fahrenheit(20);
        assertEquals(first, second);
    }

    @Test
    public void shouldBeFahrenheitAndCelsiusEqual() {
        Temperature fahrenheit = new Fahrenheit(32);
        Temperature celsius = new Celsius(0);
        assertEquals(fahrenheit,celsius);
    }

    @Test
    public void shouldBeFahrenheitAndKelvinEqual() {
        Temperature fahrenheit= new Fahrenheit(32);
        Temperature kelvin = new Kelvin(273.15);
        assertEquals(fahrenheit, kelvin);
    }

}