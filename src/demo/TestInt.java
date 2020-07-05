package demo;

import sun.misc.Unsafe;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.text.DecimalFormat;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/4/20
 * Describe :
 */
public class TestInt {
    public static void main(String[] args) {
//        String p = "8.99";
//        System.out.println(Double.valueOf(p).intValue());
        formatRMBPrice("123456789.13455765");
//        System.out.println(String.valueOf(""));
        interrupt();
        handleInterruptionThread();

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("");

    }

    private static void interrupt() {
        InterruptThread thread = new InterruptThread();
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //调用interrupt()方法中断线程
        thread.interrupt();
    }

    static class InterruptThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                //如果这里有sleep(),则调用interrupt()时会执行catch方法
                sleep(5000);
            } catch (InterruptedException e) {
                // e.printStackTrace();
                //在这里可以进行清理工作，比如打开过文件，就可以关闭了
                System.out.println("线程中断了");
            }
        }
    }

    public static void handleInterruptionThread() {
        InterruptThread1 thread1 = new InterruptThread1();
        thread1.start();

        thread1.interrupt();
    }

    static class InterruptThread1 extends Thread {
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 100000; i++) {
                if (interrupted()) {
                    break;
                }
                System.out.println(i);
            }
        }
    }

    static class InterruptThread2 extends Thread {
        volatile boolean isStopped = false;
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 100000; i++) {
                if (isStopped) {
                    return;
                }
            }
        }
    }

    public static void booleanFlag() {
        InterruptThread2 thread2 = new InterruptThread2();
        thread2.start();

        thread2.isStopped = true;
    }



    //格式化为带千分符RMB 111,234,56
    public static void formatRMBPrice(String price) {
        DecimalFormat format = new DecimalFormat(",###");
//        format.setRoundingMode(RoundingMode.HALF_UP);
        String formatPrice = format.format(new BigDecimal(price));
        System.out.println(formatPrice);
    }


}
