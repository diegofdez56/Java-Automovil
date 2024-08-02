package dev.diego;

import dev.diego.enums.CarType;
import dev.diego.enums.Color;
import dev.diego.enums.FuelType;

public class Car {
    private String brand;
    private int modelYear;
    private double engineVolume;
    private FuelType fuelType;
    private CarType carType;
    private int numberOfDoors;
    private int numberOfSeats;
    private int maxSpeed;
    private Color color;
    private int currentSpeed;
    private boolean isAutomatic;
    private int fines;
    private final int FINE_AMOUNT = 100;

    public Car(String brand, int modelYear, double engineVolume, FuelType fuelType, 
               CarType carType, int numberOfDoors, int numberOfSeats, 
               int maxSpeed, Color color, boolean isAutomatic) {
        this.brand = brand;
        this.modelYear = modelYear;
        this.engineVolume = engineVolume;
        this.fuelType = fuelType;
        this.carType = carType;
        this.numberOfDoors = numberOfDoors;
        this.numberOfSeats = numberOfSeats;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.currentSpeed = 0;
        this.isAutomatic = isAutomatic;
        this.fines = 0;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
    }

    public int getFines() {
        return fines;
    }

    public void accelerate(int increment) {
        if (currentSpeed + increment > maxSpeed) {
            System.out.println("Cannot exceed the maximum allowed speed.");
            fines++;
        } else {
            currentSpeed += increment;
        }
    }

    public void decelerate(int decrement) {
        if (currentSpeed - decrement < 0) {
            System.out.println("Speed cannot be negative.");
            currentSpeed = 0;
        } else {
            currentSpeed -= decrement;
        }
    }

    public void brake() {
        currentSpeed = 0;
    }

    public double calculateEstimatedTime(double distance) {
        if (currentSpeed == 0) {
            throw new IllegalArgumentException("Current speed is 0, cannot calculate estimated time.");
        }
        return distance / currentSpeed;
    }

    public void displayAttributes() {
        System.out.println("Brand: " + brand);
        System.out.println("Model Year: " + modelYear);
        System.out.println("Engine Volume: " + engineVolume + " liters");
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Car Type: " + carType);
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Number of Seats: " + numberOfSeats);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Color: " + color);
        System.out.println("Current Speed: " + currentSpeed + " km/h");
        System.out.println("Is Automatic: " + isAutomatic);
        System.out.println("Fines: " + fines);
    }

    public boolean hasFines() {
        return fines > 0;
    }

    public int totalFineAmount() {
        return fines * FINE_AMOUNT;
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", 2022, 2.5, FuelType.GASOLINE, 
                          CarType.SUV, 4, 5, 200, Color.BLUE, true);
        car.displayAttributes();
        car.setCurrentSpeed(100);
        car.displayAttributes();
        car.accelerate(20);
        car.displayAttributes();
        car.decelerate(50);
        car.displayAttributes();
        car.brake();
        car.displayAttributes();
    }
}
