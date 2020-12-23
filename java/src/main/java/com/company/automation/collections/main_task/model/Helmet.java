package com.company.automation.collections.main_task.model;

import java.util.Objects;

public class Helmet extends MotorcycleGear {
    private final GearType gearType = GearType.HELMET;
    private final HelmetType helmetType;

    public Helmet(String brand, String model, HelmetType helmetType, String material, String color, double weight, double price) {
        super(brand, model, material, color, weight, price);
        this.helmetType = helmetType;
    }

    @Override
    public GearType getGearType() {
        return gearType;
    }

    public HelmetType getHelmetType() {
        return helmetType;
    }

    @Override
    public String getFullName() {
        return "Helmet " +
                getBrand() + " " +
                getModel();
    }

    public String getDescription() {
        return getFullName() + ":\n" +
                "type - " + helmetType.getName() +
                ", material - " + getMaterial() +
                ", color - " + getColor() +
                ", weight - " + getWeight() +
                " kg, price - $" + getPrice();
    }

    @Override
    public String toString() {
        return super.toString().replace("]", ", ") +
                "gearType = " + gearType +
                ", helmetType = " + helmetType +
                "]\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Helmet)) return false;
        if (!super.equals(o)) return false;

        Helmet helmet = (Helmet) o;
        return gearType == helmet.gearType &&
                helmetType == helmet.helmetType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gearType, helmetType);
    }
}
