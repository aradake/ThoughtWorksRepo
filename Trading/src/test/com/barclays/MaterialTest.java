package com.barclays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialTest {

    @Test
    public void shouldAddLength(){
        Material cloth=new Material();


        cloth.add(10,'m');
        cloth.add(50,'c');

        cloth.add(10,10);
        System.out.println(cloth.getLength());

        assertEquals(20, cloth.getLength().getMeteres());
        assertEquals(60,cloth.getLength().getCentimeters());



    }
}