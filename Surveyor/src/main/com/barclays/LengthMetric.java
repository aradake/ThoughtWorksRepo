package com.barclays;

public class LengthMetric {
    private int kilometers;
    private int meters;
    private int centimeters;

    public LengthMetric(int kilometers, int meters, int centimeters) {
        this.kilometers = kilometers;
        this.meters = meters;
        this.centimeters = centimeters;
    }

    public double lengthInMeters() {
        return (this.kilometers * 1000 + this.meters + ((double) this.centimeters / 100));
    }

    public double lengthInYards() {
        return this.lengthInMeters() * 1.09361;
    }

    public LengthMetric createLengthFromMeters(double meters) {
        return new LengthMetric((int) (meters / 1000), (int) (meters % 1000), (int) (meters * 100) % 100);

    }

    public LengthMetric add(LengthMetric that) {
        double resultInMeters = this.lengthInMeters() + that.lengthInMeters();

        return createLengthFromMeters(resultInMeters);

    }

    public LengthMetric add(LengthImperial that) {
        double resultInMeters = this.lengthInMeters() + that.lengthInMeters();

        return createLengthFromMeters(resultInMeters);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof LengthMetric) {
            LengthMetric that = (LengthMetric) object;
            if (this.lengthInMeters() == that.lengthInMeters()) {
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return "LengthMetric{" +
                "kilometers=" + kilometers +
                ", meters=" + meters +
                ", centimeters=" + centimeters +
                '}';
    }


}
