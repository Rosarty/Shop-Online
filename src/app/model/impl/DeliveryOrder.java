package app.model.impl;

import app.entity.Product;
import app.model.OrderModel;

public class DeliveryOrder implements OrderModel {
    private final Product product;
    private final double deliveryChargePercentage;

    public DeliveryOrder(Product product, double deliveryChargePercentage) {
        this.product = product;
        this.deliveryChargePercentage = deliveryChargePercentage;
    }

    @Override
    public double calculateTotalCost(int quantity) {
        double totalCost = quantity * product.getPrice();
        double deliveryCharge = totalCost * (deliveryChargePercentage / 100);
        return totalCost + deliveryCharge;
    }
}
