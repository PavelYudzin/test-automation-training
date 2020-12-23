package com.company.automation.collections.main_task.model;

import java.util.Objects;

public abstract class MotorcycleGear {
    private final String brand;
    private final String model;
    private final String material;
    private final String color;
    private final double weight;
    private double price;

    public MotorcycleGear(String brand, String model, String material, String color, double weight, double price) {
        this.brand = brand;
        this.model = model;
        this.material = material;
        this.color = color;
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

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getFullName();

    public abstract String getDescription();

    public abstract GearType getGearType();

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                '[' +
                "brand = " + brand +
                ", model = " + model +
                ", material = " + material +
                ", color = " + color +
                ", weight = " + weight +
                ", price = " + price +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MotorcycleGear)) return false;

        MotorcycleGear motorcycleGear = (MotorcycleGear) o;
        return brand.equals(motorcycleGear.brand) &&
                model.equals(motorcycleGear.model) &&
                material.equals(motorcycleGear.material) &&
                color.equals(motorcycleGear.color) &&
                weight == motorcycleGear.weight &&
                price == motorcycleGear.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, material, color, weight, price);
    }
}
