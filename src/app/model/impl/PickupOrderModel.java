package app.model.impl;

import app.entity.Product;
import app.model.OrderModel;


public class PickupOrderModel implements OrderModel {
    private final Product product;

    public PickupOrderModel(Product product) {
        this.product = product;
    }


    @Override
    public double calculateTotalCost(int quantity) {
        return quantity * product.getPrice();
    }

}



