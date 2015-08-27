public class Distance {
    private int kilometers;
    private int meters;
    private int centimeters;

    public Distance(int kilometers, int meters, int centimeters) {
        this.kilometers = kilometers;
        this.meters = meters;
        this.centimeters = centimeters;
    }

    public int distanceInMeters() {
        return (this.kilometers * 1000 + this.meters + (this.centimeters / 100));
    }

    public Distance createDistanceFromMeters(double meters) {
        return new Distance((int) (meters / 1000), (int) (meters % 1000), (int) (meters * 100) % 100);

    }

    public Distance add(Distance that) {
        double resultInMeters = this.distanceInMeters() + that.distanceInMeters();

        return createDistanceFromMeters(resultInMeters);

    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Distance) {
            Distance that = (Distance) object;
            if (this.distanceInMeters() == that.distanceInMeters()) {
                return true;
            }
        }
        return false;
    }
}
