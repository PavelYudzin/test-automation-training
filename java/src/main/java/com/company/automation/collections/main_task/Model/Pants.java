package com.company.automation.collections.main_task.Model;

import java.util.Objects;

public class Pants extends MotorcycleGear {
    private GearType gearType = GearType.PANTS;
    private Gender gender;

    public Pants(Gender gender, String brand, String model, String material, String color, double weight, double price) {
        super(brand, model, material, color, weight, price);
        this.gender = gender;
    }

    public GearType getGearType() {
        return gearType;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String getDescription() {
        return (gender == Gender.WOMAN ? "Women's " : "Men's ") +
                "Pants " +
                getBrand() + " " +
                getModel() + ":\n" +
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
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pants)) return false;
        if (!super.equals(o)) return false;

        Pants pants = (Pants) o;
        return gearType == pants.gearType &&
                gender == pants.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gearType, gender);
    }
}
