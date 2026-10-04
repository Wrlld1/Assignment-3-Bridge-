package delivery;

import delivery.abstraction.Delivery;
import delivery.abstraction.ExpressDelivery;
import delivery.abstraction.InsuredDelivery;
import delivery.abstraction.StandardDelivery;
import delivery.implementor.DroneTransport;
import delivery.implementor.SidewalkRobotTransport;
import delivery.implementor.Transport;
import delivery.implementor.VanTransport;
import delivery.model.Address;
import delivery.model.DeliveryReceipt;
import delivery.model.Parcel;

// Client: picks the pairing of delivery type and transport at runtime
public class Main {

    public static void main(String[] args) {
        Address warehouse = new Address("Warehouse", 0, 0);
        Address customer = new Address("Customer", 3, 4);   // 5 km away
        Address suburb = new Address("Suburb", 12, 16);     // 20 km away

        Parcel book = new Parcel("Book", 1.0, 20.0);
        Parcel monitor = new Parcel("Monitor", 8.0, 250.0);

        Transport van = new VanTransport();
        Transport drone = new DroneTransport();
        Transport robot = new SidewalkRobotTransport();

        System.out.println("== One abstraction, transport switched at runtime ==");
        Delivery express = new ExpressDelivery(van);
        show("Express + Van", express.deliver(book, warehouse, customer));
        express.setTransport(drone);
        show("Express + Drone", express.deliver(book, warehouse, customer));
        express.setTransport(robot);
        show("Express + Robot", express.deliver(book, warehouse, customer));

        System.out.println();
        System.out.println("== One transport, different abstractions ==");
        show("Standard + Drone", new StandardDelivery(drone).deliver(book, warehouse, customer));
        show("Express + Drone", new ExpressDelivery(drone).deliver(book, warehouse, customer));
        show("Insured + Drone", new InsuredDelivery(drone).deliver(book, warehouse, customer));

        System.out.println();
        System.out.println("== Transport limits ==");
        show("Standard + Drone, heavy parcel", new StandardDelivery(drone).deliver(monitor, warehouse, customer));
        show("Standard + Robot, far address", new StandardDelivery(robot).deliver(book, warehouse, suburb));
        show("Insured + Van, heavy parcel", new InsuredDelivery(van).deliver(monitor, warehouse, suburb));
    }

    private static void show(String title, DeliveryReceipt receipt) {
        System.out.println(title + " -> " + receipt);
    }
}
