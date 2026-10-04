package delivery.implementor;

public class DroneTransport implements Transport {
    private static final double BASE_FEE = 5.0;
    private static final double PER_KM = 0.5;
    private static final double PER_KG = 2.0;

    @Override
    public String name() {
        return "Drone";
    }

    @Override
    public double maxWeightKg() {
        return 5;
    }

    @Override
    public double maxRangeKm() {
        return 15;
    }

    @Override
    public double speedKmh() {
        return 60;
    }

    @Override
    public double price(double distanceKm, double weightKg) {
        // Drones are charged mostly by weight because of battery drain
        return BASE_FEE + PER_KM * distanceKm + PER_KG * weightKg;
    }
}
