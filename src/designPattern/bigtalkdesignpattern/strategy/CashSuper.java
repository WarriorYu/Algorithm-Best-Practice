package designPattern.bigtalkdesignpattern.strategy;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/24
 * Describe : 现金收费抽象类
 */
public abstract class CashSuper {
    // 现金收取超类的抽象方法，收取现金，参数为原价，返回为当前价
    public abstract double acceptCash(double money);
}
