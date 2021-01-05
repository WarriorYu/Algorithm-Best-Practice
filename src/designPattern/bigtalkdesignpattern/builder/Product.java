package designPattern.bigtalkdesignpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/5
 * Describe : 产品类，由多个部件组成
 */
public class Product {
    private List<String> parts = new ArrayList<>();

    /**
     * 添加产品部件
     * @param part
     */
    public void add(String part) {
        parts.add(part);
    }

    /**
     * 列举所有的产品部件
     */
    public void show() {
        System.out.println("产品创建");
        for (String p : parts) {
            System.out.println(p);
        }
    }
}
