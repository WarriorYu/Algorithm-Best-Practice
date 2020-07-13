package practice.two;

import practice.MySortTestHelper;

import javax.crypto.interfaces.PBEKey;
import java.security.PublicKey;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/10
 * Describe :
 */
public class InsertSort {
    private InsertSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Comparable e = arr[i];

            /*int j = i-1;
            Comparable e = arr[i];
            for (; j >= 0; j--) {
                if (arr[j].compareTo(e) > 0) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            if (!arr[j+1].equals(e)) {
                arr[j+1] = e;
            }
*/
            int j = i;
            for (; j>0 && arr[j-1].compareTo(e)>0; j--) {
                arr[j] = arr[j-1];
            }

            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] arr = MySortTestHelper.generateRandomArray(n, 0, n);
        MySortTestHelper.printArray(arr);
        sort(arr);
        MySortTestHelper.printArray(arr);
    }
}
