package playwithdatastructures.heap_and_priority_queue_08;

import java.util.*;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/23
 * Describe :
 */
public class Main {
    public static void main(String[] args) {
        //测试普通 MaxHeap
        /*
        int n =10000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i-1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.print("Test MaxHeap completed.");
        */

        //测试通过 heapify的方式建堆和普通建堆的时间复杂度
        int n = 10000000;
        Integer[] testData1 = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            testData1[i] = random.nextInt(Integer.MAX_VALUE);
        }
        Integer[] testData2 = Arrays.copyOf(testData1, n);
        double time1 = testHeap(testData1, false);
        System.out.println("Without heapify:"+time1+"s");
        double time2 = testHeap(testData2, true);
        System.out.println("With heapify:"+time2+"s");
    }

    public static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();

        MaxHeap<Integer> heap;
        if (isHeapify) {
            heap = new MaxHeap<>(testData);
        } else {
            heap = new MaxHeap<>(testData.length);
            for (int i = 0; i < testData.length; i++) {
                heap.add(testData[i]);
            }
        }
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = heap.extractMax();
        }

        for (int i = 1; i < testData.length; i++) {
            if (arr[i-1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime-startTime)/1000000000.0;
    }
}
