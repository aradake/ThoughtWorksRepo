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


    @Override
    public boolean equals(Object object) {
        if (object instanceof Length) {
            Length that = (Length) object;
            return (this.meters * 100 + this.centimeters == that.meters * 100 + that.centimeters);


        }
        return false;
    }
}
