package delivery.abstraction;

import delivery.implementor.Transport;
import delivery.model.Parcel;
import delivery.model.Tariffs;

public class StandardDelivery extends Delivery {

    public StandardDelivery(Transport transport) {
        super(transport);
    }

    @Override
    protected double finalPrice(double transportPrice, Parcel parcel) {
        return transportPrice;
    }

    @Override
    protected int finalMinutes(int travelMinutes) {
        return travelMinutes + Tariffs.HANDLING_MINUTES;
    }
}
