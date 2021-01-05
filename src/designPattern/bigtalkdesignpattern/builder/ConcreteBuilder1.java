package designPattern.bigtalkdesignpattern.builder;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/5
 * Describe : 建造具体的两个部件
 */
public class ConcreteBuilder1 extends Builder {
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件A");
    }

    @Override
    public void buildPartB() {
        product.add("部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
