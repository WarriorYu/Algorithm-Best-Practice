package designPattern.bigtalkdesignpattern.strategy;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/24
 * Describe : 返利收费子类
 */
public class CashReturn extends CashSuper {
    private double moneyCondition = 0.0d;
    private double moneyReturn = 0.0d;

    // 返利收费，初始化时必须要输入返利条件和返利值，比如满300反100，
    // 则moneyCondition为300，moneyReturn 为100
    public CashReturn(String moneyCondition, String moneyReturn) {
        this.moneyCondition = Double.parseDouble(moneyCondition);
        this.moneyReturn = Double.parseDouble(moneyReturn);
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money >= moneyCondition) {
            // 若大于返利条件，则需要减去返利值
            result = money - Math.floor(money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
