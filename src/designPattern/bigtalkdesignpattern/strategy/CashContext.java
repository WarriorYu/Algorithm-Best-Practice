package designPattern.bigtalkdesignpattern.strategy;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/24
 * Describe :
 */
public class CashContext {
    // 声明一个CashSuper对象
    private CashSuper cs;

    // 通过构造方法，传入具体的收费策略
    public CashContext(String type) {
        switch (type) {
            case "正常收费":
                CashNormal cs0 = new CashNormal();
                cs = cs0;
                break;
            case "满300返100":
                CashReturn cr1 = new CashReturn("300", "100");
                cs = cr1;
                break;
            case "打8折":
                CashRebate cr2 = new CashRebate("0.8");
                cs = cr2;
                break;
        }
    }

    public double getResult(double money) {
        // 根据收费策略的不同，获得计算结果
        return cs.acceptCash(money);
    }
}
