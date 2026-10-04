package delivery.model;

// Service-level rules; vehicle-specific numbers live in the transports
public final class Tariffs {
    public static final int MINUTES_PER_HOUR = 60;
    public static final int HANDLING_MINUTES = 30;
    public static final double EXPRESS_MULTIPLIER = 1.5;
    public static final double EXPRESS_MIN_SPEED_KMH = 20;
    public static final double INSURANCE_RATE = 0.02;

    private Tariffs() {
    }
}
