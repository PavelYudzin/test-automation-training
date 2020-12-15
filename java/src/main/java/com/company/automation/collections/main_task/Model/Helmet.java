package com.company.automation.collections.main_task.Model;

import java.util.Objects;

public class Helmet extends MotorcycleGear {
    private GearType gearType = GearType.HELMET;
    private HelmetType helmetType;

    public Helmet(String brand, String model, HelmetType helmetType, String material, String color, double weight, double price) {
        super(brand, model, color, material, weight, price);
        this.helmetType = helmetType;
    }

    public GearType getGearType() {
        return gearType;
    }

    public HelmetType getHelmetType() {
        return helmetType;
    }


    public String getDescription() {
        return "Helmet " +
                getBrand() + " " +
                getModel() + ":\n" +
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
                ']';
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
