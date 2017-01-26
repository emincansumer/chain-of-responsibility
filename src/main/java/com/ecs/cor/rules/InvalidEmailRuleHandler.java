package main.java.com.ecs.cor.rules;

import java.util.List;

import main.java.com.ecs.cor.OrderRuleHandler;
import main.java.com.ecs.cor.models.OrderModel;

/**
 * @author emincansumer
 * @since 25/01/17
 */
public class InvalidEmailRuleHandler extends OrderRuleHandler {

    @Override
    public void applyRule(List<OrderModel> orders) {
        print("InvalidEmailRuleHandler running: " + orders.size());
        for (int i = 0; i < orders.size(); i++) {
            OrderModel order = orders.get(i);
            if (order != null && order.getEmail() != null && !order.getEmail().contains("@")) {
                print("Removing invalid email orders...");
                orders.remove(i);
            }
        }
    }
}
