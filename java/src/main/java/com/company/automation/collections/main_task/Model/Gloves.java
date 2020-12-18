package com.company.automation.collections.main_task.Model;

import java.util.Objects;

public class Gloves extends MotorcycleGear {
    private GearType gearType = GearType.GLOVES;
    private GlovesType glovesType;

    public Gloves(String brand, String model, GlovesType glovesType, String material, String color, double weight, double price) {
        super(brand, model, material, color, weight, price);
        this.glovesType = glovesType;
    }

    @Override
    public GearType getGearType() {
        return gearType;
    }

    public GlovesType getGlovesType() {
        return glovesType;
    }

    @Override
    public String getDescription() {
        return "Gloves " +
                getBrand() + " " +
                getModel() + ":\n" +
                "type - " + glovesType.getName() +
                ", material - " + getMaterial() +
                ", color - " + getColor() +
                ", weight - " + getWeight() +
                "kg, price - $" + getPrice();
    }

    @Override
    public String toString() {
        return super.toString().replace("]", ", ") +
                "gearType = " + gearType +
                ", glovesType = " + glovesType +
                "]\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gloves)) return false;
        if (!super.equals(o)) return false;

        Gloves gloves = (Gloves) o;
        return gearType == gloves.gearType &&
                glovesType == gloves.glovesType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gearType, glovesType);
    }
}
