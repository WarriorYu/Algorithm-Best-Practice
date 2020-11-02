package designPattern.strategy;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/4
 * Describe :
 */
public class Order {
    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    private OrderType type;

}
