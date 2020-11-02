package designPattern.strategy;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/4
 * Describe : 策略的使用
 */
public class OrderService {
    public double discount(Order order) {
        OrderType type = order.getType();
        DiscountStrategy discountStategy = DiscountStrategyFactory.getDiscountStategy(type);
        return discountStategy.calDiscount(order);
    }
}
