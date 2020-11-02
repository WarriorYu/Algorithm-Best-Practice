package designPattern.strategy;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/4
 * Describe :
 */
public class PromotionDiscountStrategy implements DiscountStrategy {
    @Override
    public double calDiscount(Order order) {
        return 5.5d;
    }
}
