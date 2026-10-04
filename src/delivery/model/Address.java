package delivery.model;

public final class Address {
    private final String label;
    private final double x;
    private final double y;

    // x and y are kilometres on a flat city grid
    public Address(String label, double x, double y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public double distanceKmTo(Address other) {
        return Math.hypot(x - other.x, y - other.y);
    }

    @Override
    public String toString() {
        return label;
    }
}
