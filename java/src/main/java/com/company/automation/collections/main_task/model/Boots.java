package com.company.automation.collections.main_task.model;

import java.util.Objects;

public class Boots extends MotorcycleGear {
    private final GearType gearType;
    private final BootsType bootsType;

    public Boots(String brand, String model, BootsType bootsType, String material, String color, double weight, double price) {
        super(brand, model, material, color, weight, price);
        this.bootsType = bootsType;
        gearType = GearType.BOOTS;
    }

    @Override
    public GearType getGearType() {
        return gearType;
    }

    public BootsType getBootsType() {
        return bootsType;
    }

    @Override
    public String getFullName() {
        return "Boots " +
                getBrand() + " " +
                getModel();
    }

    @Override
    public String getDescription() {
        return getFullName() + ":\n" +
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
                ", glovesType = " + bootsType +
                "]\n";
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
