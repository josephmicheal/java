package com.approach1.simple.enumeration;

public class ShippingCostCalculator {

    public double calculateShippingCost(ShippingType shippingType, double weight) {
        return shippingType.getCost(weight);
    }

    public static void main(String[] args) {
        var calculator = new ShippingCostCalculator();
        var cost = calculator.calculateShippingCost(ShippingType.EXPRESS, 2.5);
        System.out.println("Shipping cost: " + cost);
    }
}