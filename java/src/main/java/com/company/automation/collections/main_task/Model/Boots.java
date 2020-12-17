package com.company.automation.collections.main_task.Model;

import java.util.Objects;

public class Boots extends MotorcycleGear {
    private GearType gearType = GearType.BOOTS;
    private BootsType bootsType;

    public Boots(String brand, String model, BootsType bootsType, String material, String color, double weight, double price) {
        super(brand, model, material, color, weight, price);
        this.bootsType = bootsType;
    }

    public GearType getGearType() {
        return gearType;
    }

    public BootsType getBootsType() {
        return bootsType;
    }

    @Override
    public String getDescription() {
        return "Boots " +
                getBrand() + " " +
                getModel() + ":\n" +
                "type - " + bootsType.getName() +
                ", material - " + getMaterial() +
                ", color - " + getColor() +
                ", weight - " + getWeight() +
                "kg, price - $" + getPrice();
    }

    @Override
    public String toString() {
        return super.toString().replace("]", ", ") +
                "gearType = " + gearType +
                "glovesType = " + bootsType +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boots)) return false;
        if (!super.equals(o)) return false;

        Boots boots = (Boots) o;
        return gearType == boots.gearType &&
                bootsType == boots.bootsType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gearType, bootsType);
    }
}