package com.company.automation.collections.main_task.model;

import java.util.Objects;

public class Jacket extends MotorcycleGear {
    private final GearType gearType;
    private final Gender gender;

    public Jacket(Gender gender, String brand, String model, String material, String color, double weight, double price) {
        super(brand, model, material, color, weight, price);
        this.gender = gender;
        gearType = GearType.JACKET;
    }

    @Override
    public GearType getGearType() {
        return gearType;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String getFullName() {
        return (gender == Gender.WOMAN ? "Women's " : "Men's ") +
                "Jacket " +
                getBrand() + " " +
                getModel();
    }

    @Override
    public String getDescription() {
        return getFullName() + ":\n" +
                "material - " + getMaterial() +
                ", color - " + getColor() +
                ", weight - " + getWeight() +
                "kg, price - $" + getPrice();
    }

    @Override
    public String toString() {
        return super.toString().replace("]", ", ") +
                "gearType = " + gearType +
                ", gender = " + gender +
                "]\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jacket)) return false;
        if (!super.equals(o)) return false;

        Jacket jacket = (Jacket) o;
        return gearType == jacket.gearType &&
                gender == jacket.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gearType, gender);
    }
}
