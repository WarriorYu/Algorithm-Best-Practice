package designPattern.singleton;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/10
 * Describe : 单例的几种写法
 */
public class SingleTon {
    private SingleTon(){}
//    private static final SingleTon instance = new SingleTon();
//    private static SingleTon getInstance(){
//        return instance;
//    }

//    private static SingleTon instance;
//    private static SingleTon getInstance(){
//        if(instance == null){
//            synchronized(SingleTon.class){
//                if(instance == null){
//                    instance = new SingleTon();
//                }
//            }
//        }
//        return instance;
//    }

//    private static class SingleTonHolder{
//        private static final SingleTon instance = new SingleTon();
//    }
//    private static SingleTon getInstance() {
//        return SingleTonHolder.instance;
//    }


    public static void main(String[] args) {
//        SingleTon.getInstance();
        SingTon2 instance = SingTon2.INSTANCE;
    }
}
