package designPattern.bigtalkdesignpattern.template;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/5
 * Describe : 模板设计模式
 */
public class TemplateClient {
    public static void main(String[] args) {
        AbstractClass abstractClass;

        abstractClass = new ConcreteClassA();
        abstractClass.templateMethod();


        abstractClass = new ConcreteClassB();
        abstractClass.templateMethod();
    }
}
