package main.java.com.ecs.cor.rules;

import main.java.com.ecs.cor.OrderRuleHandler;
import main.java.com.ecs.cor.models.OrderModel;

import java.util.List;

/**
 * @author emincansumer
 * @since 25/01/17
 */
public class CountryRuleHandler extends OrderRuleHandler {

    @Override
    public void applyRule(List<OrderModel> orders) {
        print("CountryRuleHandler running: " + orders.size());
        for (int i = 0; i < orders.size(); i++) {
            OrderModel order = orders.get(i);
            if (order != null && "DE".equalsIgnoreCase(order.getCountry())) {
                print("Removing DE order...");
                orders.remove(i);
            }
        }
    }
}
