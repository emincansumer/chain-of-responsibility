package main.java.com.ecs.cor;

import main.java.com.ecs.cor.models.OrderModel;

import java.util.List;

/**
 * @author emincansumer
 * @since 25/01/17
 */
public abstract class OrderRuleHandler {

    private OrderRuleHandler next;

    public void setNextRuleHandler(OrderRuleHandler next) {
        this.next = next;
    }

    public void process(List<OrderModel> orders) {
        applyRule(orders);
        if (next != null) {
            next.process(orders);
        }
    }

    protected void print(String message) {
        System.out.println(message);
    }

    public abstract void applyRule(List<OrderModel> orders);
}
