package com.barclays;
import org.junit.Test;

import static org.junit.Assert.*;

public class LengthTest {

    public void shouldAddTwoMetrics() {
        LengthMetric first=new LengthMetric(10,50,0);
        LengthMetric second=new LengthMetric(20,300,0);
        LengthMetric result=first.add(second);
        LengthMetric expected=new LengthMetric(30,350,0);
        System.out.println(result);
        assertEquals(expected,result);
    }


    public void shouldAddMetricAndImperial(){
        LengthMetric first=new LengthMetric(0,0,29);
        LengthImperial second=new LengthImperial(0,300,0);
        LengthMetric result=first.add(second);
        LengthMetric expected=new LengthMetric(30,350,0);
        System.out.println(result);
        assertEquals(expected,result);


    }


    @Test
    public void shouldAddwImperialAndMetric(){
        LengthImperial first=new LengthImperial(0,0,0);
        LengthMetric second=new LengthMetric(0,0,31);
        LengthImperial result=first.add(second);
        LengthImperial expected=new LengthImperial(0,1,0);
        System.out.println(result);

        assertEquals(expected,result);
    }

    public void shouldAddTwoImperials()
    {
        LengthImperial first=new LengthImperial(10,50,0);
        LengthImperial second=new LengthImperial(20,300,0);
        LengthImperial result=first.add(second);
        LengthImperial expected=new LengthImperial(30,350,0);
        System.out.println(result);
        assertEquals(expected,result);
    }
}