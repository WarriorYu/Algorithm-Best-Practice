package designPattern.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/4
 * Describe : 策略的创建
 */
public class DiscountStrategyFactory {
    private static final Map<OrderType, DiscountStrategy> stategies = new HashMap<>();

    static {
        stategies.put(OrderType.NORMAL, new NormalDiscountStrategy());
        stategies.put(OrderType.GROUPON, new GrouponDiscountStrategy());
        stategies.put(OrderType.PROMOTION, new PromotionDiscountStrategy());
    }

    public static DiscountStrategy getDiscountStategy(OrderType type) {
        return stategies.get(type);
    }
}
