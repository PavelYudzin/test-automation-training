package com.company.automation.collections.main_task.Model;

import java.util.Objects;

public abstract class MotorcycleGear {
    private final String brand;
    private final String model;
    private final double weight;
    private double price;

    public MotorcycleGear(String brand, String model, double weight, double price) {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getDescription();

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                '[' +
                "brand = " + brand +
                ", model = " + model +
                ", weight = " + weight +
                ", price = " + price +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MotorcycleGear)) return false;

        MotorcycleGear motorcycleGear = (MotorcycleGear) o;
        return  brand.equals(motorcycleGear.brand) &&
                model.equals(motorcycleGear.model) &&
                weight == motorcycleGear.weight &&
                price == motorcycleGear.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, weight, price);
    }
}
