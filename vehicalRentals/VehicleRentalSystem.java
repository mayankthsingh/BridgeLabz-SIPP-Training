package sipp;
// Base class
class Vehicle {
    protected String model;
    protected String number;
    protected double baseRate;

    public Vehicle(String model, String number, double baseRate) {
        this.model = model;
        this.number = number;
        this.baseRate = baseRate;
    }

    // Encapsulation
    public String getModel() { return model; }
    public String getNumber() { return number; }
    public double getBaseRate() { return baseRate; }
}

// Bike class
class Bike extends Vehicle implements Rentable {
    public Bike(String model, String number, double baseRate) {
        super(model, number, baseRate);
    }

    public double calculateRent(int days) {
        return baseRate * days;
    }
}

// Car class
class Car extends Vehicle implements Rentable {
    private boolean isLuxury;

    public Car(String model, String number, double baseRate, boolean isLuxury) {
        super(model, number, baseRate);
        this.isLuxury = isLuxury;
    }

    public double calculateRent(int days) {
        double surcharge = isLuxury ? 200 : 100;
        return baseRate * days + surcharge;
    }
}

// Truck class
class Truck extends Vehicle implements Rentable {
    private double load;

    public Truck(String model, String number, double baseRate, double load) {
        super(model, number, baseRate);
        this.load = load;
    }

    public double calculateRent(int days) {
        return baseRate * days + load * 10; // Additional charge per ton
    }
}

// Customer class
class Customer {
    private String name;
    private String license;

    public Customer(String name, String license) {
        this.name = name;
        this.license = license;
    }

    public void rentVehicle(Rentable vehicle, int days) {
        double cost = vehicle.calculateRent(days);
        System.out.println(name + " rented a vehicle for " + days + " days. Total Rent = ₹" + cost);
    }
}


public class VehicleRentalSystem {
    public static void main(String[] args) {
        Customer customer = new Customer("xxxxxxxx", "DL123456");

        Bike bike = new Bike("Yamaha", "BK101", 100);
        Car car = new Car("Honda City", "CR202", 500, true);
        Truck truck = new Truck("Tata 407", "TR303", 800, 5); // 5 tons

        customer.rentVehicle(bike, 3);
        customer.rentVehicle(car, 2);
        customer.rentVehicle(truck, 1);
    }
}
