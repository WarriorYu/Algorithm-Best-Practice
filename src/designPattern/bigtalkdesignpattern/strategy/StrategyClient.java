package designPattern.bigtalkdesignpattern.strategy;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/24
 * Describe :
 */
public class StrategyClient {
    public static void main(String[] args) {
        CashContext cashContext = new CashContext("满300返100");
        double result = cashContext.getResult(500);
        System.out.println(result);

    }
}
