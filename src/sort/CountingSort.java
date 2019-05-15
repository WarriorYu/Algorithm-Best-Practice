package sort;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/5/15
 * Describe : 计数排序
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 3,0, 8, 9, 5, 1};
        countingSort(arr, arr.length);

    }

    /**
     * @param a 数组
     * @param n 数组大小
     */
    private static void countingSort(int[] a, int n) {
        //1、找出数组a中最大的元素max
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        //2、创建max+1个元素的数组c，遍历数组a的元素，a元素的值作为c数组的下标index，c数组中元素的值为index对应值的个数
        int[] c = new int[max + 1];
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        //3、将数组c中的元素累加
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i - 1] + c[i];
        }

        //4、新建数组r，遍历a组数，拿a数组的值作为下标去查c数组对应的值，这个值减1后就是在r数组中的下标
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            int index = --c[a[i]];
            r[index] = a[i];
        }
        //5、将结果拷贝回a数组
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
            System.out.print(r[i]+", ");
        }
    }
}
