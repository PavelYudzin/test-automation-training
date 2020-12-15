package com.company.automation.collections.main_task.Model;

import java.util.Objects;

public class Jacket extends MotorcycleGear {
    private GearType gearType = GearType.JACKET;

    public Jacket(String brand, String model, String material, String color, double weight, double price) {
        super(brand, model, material, color, weight, price);
    }

    public GearType getGearType() {
        return gearType;
    }

    @Override
    public String getDescription() {
        return "Jacket " +
                getBrand() + " " +
                getModel() + ":\n" +
                "material - " + getMaterial() +
                ", color - " + getColor() +
                ", weight - " + getWeight() +
                "kg, price - $" + getPrice();
    }

    @Override
    public  String toString() {
        return super.toString().replace("]", ", ") +
                "gearType = " + gearType +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jacket)) return false;
        if(!super.equals(o)) return false;

        Jacket jacket = (Jacket) o;
        return gearType == jacket.gearType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gearType);
    }
}
