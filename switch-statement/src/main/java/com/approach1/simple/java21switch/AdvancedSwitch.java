package com.approach1.simple.java21switch;

public class AdvancedSwitch {

    public static void main(String[] args) {
        System.out.println(
                calculateShippingCost2("STANDARD", 10.23));
    }

    public static double calculateShippingCost2(String shippingType, double weight) {
        return switch (shippingType) {
            case null -> throw new IllegalArgumentException();
            case "STANDARD" -> weight * 5.0;
            case "EXPRESS" -> weight * 10.0;
            case "SAME_DAY" -> weight * 20.0;
            case "INTERNATIONAL" -> weight * 50.0;
            case "OVERNIGHT" -> weight * 30.0;
            default -> 0;
        };
    }
}
