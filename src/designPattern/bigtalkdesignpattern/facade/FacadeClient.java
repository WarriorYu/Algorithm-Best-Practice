package designPattern.bigtalkdesignpattern.facade;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/5
 * Describe : 外观（门面）模式
 */
public class FacadeClient {
    public static void main(String[] args) {
        Facade facade = new Facade();
        // 以为Facade的存在，客户端可以根本不知子系统的存在
        facade.methodA();
        facade.methodB();
    }
}
