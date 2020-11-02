package exam;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/24
 * Describe :
 */
public class WrapClass {
    public static void main(String[] args) {
//        Type superType = Son.class.getGenericSuperclass();//如果使用继承
//        Type superType = Son.class.getGenericInterfaces();//如果使用接口
//        //获得泛型列表
//        Type daoType = ((ParameterizedType) superType).getActualTypeArguments()[0];
        Son son = new Son();
        Class<? extends Son> clazz = son.getClass();
        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        System.out.println(clazz.getGenericSuperclass());
        ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] types = pt.getActualTypeArguments();
        System.out.println(types[0]);
        System.out.println("---------------------");

        ArrayList<Son> list = new ArrayList<>();

        Class<? extends ArrayList> clazz2 = list.getClass();
        System.out.println(clazz2);
        System.out.println(clazz2.getSuperclass());
        System.out.println(clazz2.getGenericSuperclass());
        ParameterizedType pt2 = (ParameterizedType) clazz2.getGenericSuperclass();
        Type[] types2 = pt2.getActualTypeArguments();
        System.out.println(types2[0]);


    }
}
