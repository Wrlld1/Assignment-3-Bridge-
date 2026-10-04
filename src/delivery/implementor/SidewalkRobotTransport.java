package delivery.implementor;

public class SidewalkRobotTransport implements Transport {
    private static final double BASE_FEE = 1.5;
    private static final double PER_KM = 0.3;

    @Override
    public String name() {
        return "SidewalkRobot";
    }

    @Override
    public double maxWeightKg() {
        return 10;
    }

    @Override
    public double maxRangeKm() {
        return 3;
    }

    @Override
    public double speedKmh() {
        return 6;
    }

    @Override
    public double price(double distanceKm, double weightKg) {
        return BASE_FEE + PER_KM * distanceKm;
    }
}
