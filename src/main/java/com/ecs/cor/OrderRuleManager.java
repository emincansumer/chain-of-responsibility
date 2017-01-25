package main.java.com.ecs.cor;

import main.java.com.ecs.cor.models.OrderModel;
import main.java.com.ecs.cor.rules.CountryRuleHandler;
import main.java.com.ecs.cor.rules.InvalidEmailRuleHandler;
import main.java.com.ecs.cor.rules.ZeroPriceRuleHandler;

import java.util.List;

/**
 * @author emincansumer
 * @since 25/01/17
 */
public class OrderRuleManager {

    private OrderRuleHandler chainTrigger;

    public OrderRuleManager() {
        buildChain();
    }

    private void buildChain() {
        chainTrigger = new InvalidEmailRuleHandler();
        OrderRuleHandler countryRuleHandler = new CountryRuleHandler();
        OrderRuleHandler zeroPriceRuleHandler = new ZeroPriceRuleHandler();

        chainTrigger.setNextRuleHandler(countryRuleHandler);
        countryRuleHandler.setNextRuleHandler(zeroPriceRuleHandler);
    }

    public void applyRules(List<OrderModel> orders) {
        chainTrigger.process(orders);
    }
}
