# Delivery System (Bridge pattern)

Java implementation of the Bridge pattern. A delivery type (what the customer
buys: standard, express, insured) is separated from the transport (how the parcel
moves: van, drone, robot), so both sides can grow independently.

## Classes

- `Delivery` - Abstraction, holds a `Transport` and applies pricing/time rules
- `StandardDelivery`, `ExpressDelivery`, `InsuredDelivery` - Refined Abstractions
- `Transport` - Implementor, low-level vehicle capabilities
- `VanTransport`, `DroneTransport`, `SidewalkRobotTransport` - Concrete Implementors
- `Address`, `Parcel` - value objects
- `DeliveryReceipt`, `DeliveryStatus` - result of a delivery and its status enum
- `Tariffs` - service-level constants
- `Main` - client, composes and switches implementations at runtime

## Example

```java
Delivery delivery = new ExpressDelivery(new VanTransport());
delivery.deliver(parcel, warehouse, customer);

delivery.setTransport(new DroneTransport());   // abstraction is unchanged
delivery.deliver(parcel, warehouse, customer);
```

## Clean Code principles

1. Separation of sides: `Delivery` knows business rules, `Transport` knows only vehicle facts.
2. Meaningful names: `Delivery` / `Transport` show the role of each side of the bridge.
3. Small focused classes: each class has one job and fits on one screen.
4. No duplication: shared flow lives in `Delivery.deliver`, `InsuredDelivery` reuses `StandardDelivery`.
5. Open/closed: a new transport is a new class, `Delivery` and the client logic stay untouched.

## How to run


```powershell
javac -d out (Get-ChildItem -Path src -Recurse -Filter *.java).FullName
java -cp out delivery.Main
```

