package app.controller;


import app.model.OrderModel;

public class OrderController {
    private final OrderModel order;

    public OrderController(OrderModel order) {
        this.order = order;
    }

    public double getTotalCost(int quantity) {
        return order.calculateTotalCost(quantity);
    }

}