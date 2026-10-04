package delivery.implementor;

// Implementor: low-level capabilities of a vehicle, nothing about delivery rules
public interface Transport {
    String name();

    double maxWeightKg();

    double maxRangeKm();

    double speedKmh();

    double price(double distanceKm, double weightKg);
}
