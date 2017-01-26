package main.java.com.ecs.cor;

import java.util.ArrayList;
import java.util.List;

import main.java.com.ecs.cor.models.OrderModel;
import main.java.com.ecs.cor.models.OrderState;

/**
 * @author emincansumer
 * @since 25/01/17
 */
public class Application {
    public static void main(String[] args) {
        List<OrderModel> orders = createOrders();
        OrderRuleManager manager = new OrderRuleManager();
        manager.applyRules(orders);
        System.out.println("Remaining orders: " + orders.size());
    }

    private static List<OrderModel> createOrders() {
        List<OrderModel> orders = new ArrayList<>();
        orders.add(createOrder("testemail", "DE",
                            OrderState.AWAITING_PROCESS, 1, "Test Product 1"));
        orders.add(createOrder("testemail@test.com", "TR",
                               OrderState.AWAITING_PROCESS, 1, "Test Product 2"));
        orders.add(createOrder("testemail2@test.com", "US",
                               OrderState.AWAITING_PROCESS, 0, "Test Product 3"));
        orders.add(createOrder("testemail4@test.com", "TR",
                               OrderState.AWAITING_PROCESS, 1, "Test Product 2"));
        orders.add(createOrder("testemail1@test.com", "DE",
                               OrderState.AWAITING_PROCESS, 1, "Test Product 4"));
        orders.add(createOrder("testemail2", "US",
                               OrderState.AWAITING_PROCESS, 1, "Test Product 1"));
        orders.add(createOrder("testemail1@test.com", "TR",
                               OrderState.AWAITING_PROCESS, 0, "Test Product 2"));
        orders.add(createOrder("testemail4", "TR",
                               OrderState.AWAITING_PROCESS, 1, "Test Product 3"));

        return orders;
    }

    private static OrderModel createOrder(String email, String country, OrderState orderState,
                                          int price, String productName) {
        OrderModel order = new OrderModel();
        order.setEmail(email);
        order.setCountry(country);
        order.setCurrentState(orderState);
        order.setPrice(price);
        order.setProductName(productName);
        return order;
    }
}
