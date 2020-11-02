package designPattern.dynamicproxy;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/2
 * Describe :
 */
public class ProxyModel implements IShop {
    @Override
    public void buy() {
        System.out.println("我要买买买！");
    }

    @Override
    public void go() {
        System.out.println("我要go go go！");
    }
}
