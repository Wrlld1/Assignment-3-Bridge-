package delivery.abstraction;

import delivery.implementor.Transport;
import delivery.model.Address;
import delivery.model.DeliveryReceipt;
import delivery.model.Parcel;
import delivery.model.Tariffs;

import java.util.Objects;

// Abstraction: business rules of a delivery; the vehicle is hidden behind Transport
public abstract class Delivery {
    private Transport transport;

    protected Delivery(Transport transport) {
        this.transport = Objects.requireNonNull(transport);
    }

    // The bridge can be re-pointed at runtime
    public void setTransport(Transport transport) {
        this.transport = Objects.requireNonNull(transport);
    }

    public DeliveryReceipt deliver(Parcel parcel, Address from, Address to) {
        double km = from.distanceKmTo(to);
        if (parcel.getWeightKg() > transport.maxWeightKg()) {
            return DeliveryReceipt.rejected(transport.name(), "parcel is too heavy");
        }
        if (km > transport.maxRangeKm()) {
            return DeliveryReceipt.rejected(transport.name(), "destination is out of range");
        }
        double basePrice = transport.price(km, parcel.getWeightKg());
        int travelMinutes = (int) Math.ceil(km / transport.speedKmh() * Tariffs.MINUTES_PER_HOUR);
        return DeliveryReceipt.delivered(transport.name(),
                finalPrice(basePrice, parcel), finalMinutes(travelMinutes));
    }

    // Subclasses read the transport only through this getter
    protected Transport transport() {
        return transport;
    }

    protected abstract double finalPrice(double transportPrice, Parcel parcel);

    protected abstract int finalMinutes(int travelMinutes);
}
