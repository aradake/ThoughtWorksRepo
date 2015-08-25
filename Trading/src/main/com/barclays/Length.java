package com.barclays;

public class Length {
    private int meteres;
    private int centimeters;

    public Length() {
        this.meteres=0;
        this.centimeters=0;
    }

    public Length(int meteres, int centimeters) {
        this.meteres = meteres;
        this.centimeters = centimeters;
    }

    public void add(int meters,int centimeters)
    {
        this.centimeters+=centimeters;
        this.meteres+=(this.centimeters/100);
        this.centimeters=this.centimeters%100;
        this.meteres+=meters;
    }

    public int getMeteres() {
        return meteres;
    }

    public int getCentimeters() {
        return centimeters;
    }

    @Override
    public String toString() {
        return "Length{" +
                "meteres=" + meteres +
                ", centimeters=" + centimeters +
                '}';
    }
}
