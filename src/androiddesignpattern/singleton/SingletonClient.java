package androiddesignpattern.singleton;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/11
 * Describe :
 */
public class SingletonClient {
    public static void main(String[] args) {
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        Singleton3 instance3 = Singleton3.getInstance();
        Singleton4 instance4 = Singleton4.getInstance();
        Singleton5 instance5 = Singleton5.Instance;

    }
}
