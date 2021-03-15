package designPattern.bigtalkdesignpattern.facade;

import javax.jws.Oneway;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/5
 * Describe : 外观类，他需要知道所有子系统的方法和属性，进行组合，以备外界调用
 */
public class Facade {

    private final SubSystermOne systermOne;
    private final SubSystermTwo systermTwo;
    private final SubSystermThree systermThree;
    private final SubSystermFour systermFour;

    public Facade() {
        systermOne = new SubSystermOne();
        systermTwo = new SubSystermTwo();
        systermThree = new SubSystermThree();
        systermFour = new SubSystermFour();
    }

    public void methodA() {
        System.out.println("---------------------方法组A---------------------");
        systermOne.methodOne();
        systermTwo.methodTwo();
        systermThree.methodThree();
        systermFour.methodFour();
    }

    public void methodB() {
        System.out.println("---------------------方法组B---------------------");
        systermTwo.methodTwo();
        systermFour.methodFour();
    }
}
