package delivery.model;

import java.util.Locale;

public final class DeliveryReceipt {
    private final DeliveryStatus status;
    private final String transportName;
    private final double price;
    private final int minutes;
    private final String reason;

    private DeliveryReceipt(DeliveryStatus status, String transportName,
                            double price, int minutes, String reason) {
        this.status = status;
        this.transportName = transportName;
        this.price = price;
        this.minutes = minutes;
        this.reason = reason;
    }

    public static DeliveryReceipt delivered(String transportName, double price, int minutes) {
        return new DeliveryReceipt(DeliveryStatus.DELIVERED, transportName, price, minutes, "");
    }

    public static DeliveryReceipt rejected(String transportName, String reason) {
        return new DeliveryReceipt(DeliveryStatus.REJECTED, transportName, 0, 0, reason);
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        if (status == DeliveryStatus.REJECTED) {
            return String.format("[%s] via %s: %s", status, transportName, reason);
        }
        // Locale.US keeps the decimal point the same on any OS
        return String.format(Locale.US, "[%s] via %s: price %.2f, %d min",
                status, transportName, price, minutes);
    }
}
