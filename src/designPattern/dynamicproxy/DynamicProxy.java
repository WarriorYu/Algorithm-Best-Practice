package designPattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/2
 * Describe : 动态代理
 */
public class DynamicProxy {
    public static void main(String[] args) {
        ProxyModel model = new ProxyModel();
        DynamicProxyHander proxyHander = new DynamicProxyHander(model);
        IShop proxyInstance = (IShop) Proxy.newProxyInstance(model.getClass().getClassLoader(), model.getClass().getInterfaces(), proxyHander);

        proxyInstance.buy();
    }

    private static class DynamicProxyHander implements InvocationHandler{
        private Object obj;

        public DynamicProxyHander(Object obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("开始购买");
            Object result = method.invoke(obj, args);
            System.out.println("结束购买");
            return result;
        }
    }
}
