package practice;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/5
 * Describe : 优化的冒泡排序。
 *            时间复杂度O(n^2)  空间复杂度O(1)   原地、稳定排序
 */
public class BubbleSort {
    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length - 1;
        // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
        int index = 0;

        for (int i = 0; i < n; i++) {

            //标记是否有元素交换
            boolean changeFlag = false;
            for (int j = 0; j < n; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    //将大的元素放在最后
                    swap(arr, j, j + 1);
                    changeFlag = true;
                    index = j + 1;
                }
            }
            n = index;
            //不再有元素交换，说明已经有序，退出整个循环
            if (!changeFlag) {
                break;
            }
        }
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 20;
        Integer[] array = MySortTestHelper.generateRandomArray(n, 0, n);
        MySortTestHelper.printArray(array);
        MySortTestHelper.testSort("practice.BubbleSort", array);
        MySortTestHelper.printArray(array);
    }
}
