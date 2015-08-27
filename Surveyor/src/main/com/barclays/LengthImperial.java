package com.barclays;

public class LengthImperial {
    private int mile;
    private int yard;
    private int foot;

    public LengthImperial(int mile, int yard, int foot) {
        this.mile = mile;
        this.yard = yard;
        this.foot = foot;
    }

    public double lengthInYards() {
        return (this.mile * 1760 + this.yard + ((double) this.foot / 3));
    }

    public double lengthInMeters() {
        return this.lengthInYards() * 0.9144;
    }

    public LengthImperial createLengthFromYards(double yards) {
        return new LengthImperial((int) (yards / 1760), (int) (yards % 1760), (int) (Math.ceil(yards - (int) yards) * 3));

    }

    public LengthImperial add(LengthImperial that) {
        double resultInYards = this.lengthInYards() + that.lengthInYards();


        return createLengthFromYards(resultInYards);

    }

    public LengthImperial add(LengthMetric that) {

        double resultInYards = this.lengthInYards() + that.lengthInYards();
        System.out.println("Result in yards=" + this + that);
        return createLengthFromYards(resultInYards);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof LengthImperial) {
            LengthImperial that = (LengthImperial) object;
            if (this.lengthInYards() == that.lengthInYards()) {
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return "LengthImperial{" +
                "mile=" + mile +
                ", yard=" + yard +
                ", foot=" + foot +
                '}';
    }

}
