package com.approach1.simple.ifelse;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(
                new App().calculateShippingCost("STANDARD", 20.22));

        System.out.println(
                new App().calculateShippingCost("", 20.22));
    }

    public double calculateShippingCost(String shippingType, double weight) {
        if (shippingType.equals("STANDARD")) {
            return weight * 5.0;
        } else if (shippingType.equals("EXPRESS")) {
            return weight * 10.0;
        } else if (shippingType.equals("SAME_DAY")) {
            return weight * 20.0;
        } else if (shippingType.equals("INTERNATIONAL")) {
            return weight * 50.0;
        } else if (shippingType.equals("OVERNIGHT")) {
            return weight * 30.0;
        }
        return 0;
    }
}
