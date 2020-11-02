package demo;

import com.sun.javafx.util.WeakReferenceQueue;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/10/21
 * Describe :
 */
public class TestWeakReference {
    public static void main(String[] args) {
        ReferenceQueue<Car> queue = new ReferenceQueue<>();
        Car car = new Car();
        WeakReference<Car> reference = new WeakReference<Car>(car, queue);
        System.out.println("before gc ,reference.get() is " + reference.get());
        System.out.println("before gc ,queue is " + queue.poll());
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after gc ,reference.get() is " + reference.get());
        System.out.println("after gc ,queue is " + queue.poll());
/*
        Car car = new Car();
        WeakReference<Car> weakCar = new WeakReference<Car>(car);

        System.out.println("before gc ,reference.get() is " + weakCar.get());

        System.gc();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after gc ,reference.get() is " + weakCar.get());*/




//        int i=0;

        /*while(true){
//            System.out.println("here is the strong reference 'car' "+car);//use the strong reference in the while loop
            if(weakCar.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakCar);
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }*/
    }

    static class Car {

    }
}
