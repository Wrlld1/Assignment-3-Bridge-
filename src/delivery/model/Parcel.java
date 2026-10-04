package delivery.model;

public final class Parcel {
    private final String description;
    private final double weightKg;
    private final double declaredValue;

    public Parcel(String description, double weightKg, double declaredValue) {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("weight must be positive");
        }
        if (declaredValue < 0) {
            throw new IllegalArgumentException("declared value must not be negative");
        }
        this.description = description;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public String getDescription() {
        return description;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public double getDeclaredValue() {
        return declaredValue;
    }
}
