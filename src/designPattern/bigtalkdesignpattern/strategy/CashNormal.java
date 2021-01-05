package designPattern.bigtalkdesignpattern.strategy;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/24
 * Describe : 正常收费子类
 */
public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
