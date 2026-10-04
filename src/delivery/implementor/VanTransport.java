package delivery.implementor;

public class VanTransport implements Transport {
    private static final double BASE_FEE = 3.0;
    private static final double PER_KM = 0.8;
    private static final double PER_KG = 0.1;

    @Override
    public String name() {
        return "Van";
    }

    @Override
    public double maxWeightKg() {
        return 50;
    }

    @Override
    public double maxRangeKm() {
        return 100;
    }

    @Override
    public double speedKmh() {
        return 40;
    }

    @Override
    public double price(double distanceKm, double weightKg) {
        return BASE_FEE + PER_KM * distanceKm + PER_KG * weightKg;
    }
}
