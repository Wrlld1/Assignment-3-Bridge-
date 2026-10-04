package delivery.abstraction;

import delivery.implementor.Transport;
import delivery.model.Address;
import delivery.model.DeliveryReceipt;
import delivery.model.Parcel;
import delivery.model.Tariffs;

public class ExpressDelivery extends Delivery {

    public ExpressDelivery(Transport transport) {
        super(transport);
    }

    @Override
    public DeliveryReceipt deliver(Parcel parcel, Address from, Address to) {
        if (transport().speedKmh() < Tariffs.EXPRESS_MIN_SPEED_KMH) {
            return DeliveryReceipt.rejected(transport().name(), "too slow for express");
        }
        return super.deliver(parcel, from, to);
    }

    @Override
    protected double finalPrice(double transportPrice, Parcel parcel) {
        return transportPrice * Tariffs.EXPRESS_MULTIPLIER;
    }

    // Express parcels skip the handling queue
    @Override
    protected int finalMinutes(int travelMinutes) {
        return travelMinutes;
    }
}
