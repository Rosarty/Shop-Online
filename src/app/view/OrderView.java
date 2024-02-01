package app.view;

import app.controller.OrderController;
import app.entity.Product;
import app.model.impl.DeliveryOrder;
import app.model.impl.PickupOrderModel;
import app.utils.Rounder;

import java.util.Scanner;

public class OrderView {

    private final static String CURRENCY = "USD";

    public void getOutput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter price: ");
        double price = scanner.nextDouble();

        Product product = new Product(name, price);

        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Is delivery needed? (yes/no): ");
        String deliveryNeeded = scanner.nextLine();

        OrderController controller;
        if (deliveryNeeded.equalsIgnoreCase("yes")) {
            System.out.println("Enter delivery charge percentage: ");
            double deliveryChargePercentage = scanner.nextDouble();
            controller = new OrderController(new DeliveryOrder(product, deliveryChargePercentage));
        } else {
            controller = new OrderController(new PickupOrderModel(product));
        }
        String totalCost = Rounder.roundValue(controller.getTotalCost(quantity));
        System.out.println("Product: " + product.getName() + ", " +
                "Total cost: " + totalCost + " " + CURRENCY);
    }
}
