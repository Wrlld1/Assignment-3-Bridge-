package delivery.abstraction;

import delivery.implementor.Transport;
import delivery.model.Parcel;
import delivery.model.Tariffs;

// Standard delivery plus an insurance fee based on the declared value
public class InsuredDelivery extends StandardDelivery {

    public InsuredDelivery(Transport transport) {
        super(transport);
    }

    @Override
    protected double finalPrice(double transportPrice, Parcel parcel) {
        return super.finalPrice(transportPrice, parcel)
                + parcel.getDeclaredValue() * Tariffs.INSURANCE_RATE;
    }
}
