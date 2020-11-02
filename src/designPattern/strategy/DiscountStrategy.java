package designPattern.strategy;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/4
 * Describe : 策略模式 之 策略的定义
 */
public interface DiscountStrategy {
    double calDiscount(Order order);
}
