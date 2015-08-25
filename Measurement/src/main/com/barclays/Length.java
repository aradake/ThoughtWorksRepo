package com.barclays;

public class Length {

    private int meters;
    private int centimeters;

    public Length(int meters, int centimeters) {
        this.meters = meters;
        this.centimeters = centimeters;
    }

    public int getMeters() {
        return meters;
    }

    public int getCentimeters() {
        return centimeters;
    }

    public Length add(Length that) {
        Length result = new Length(0, 0);
        result.meters = this.meters + that.meters;
        result.centimeters = this.centimeters + that.centimeters;
        return result;
    }

    public boolean compare(Length that) {
        if (this.meters == that.meters && this.centimeters == that.centimeters)
            return true;

        return false;

    }


}
