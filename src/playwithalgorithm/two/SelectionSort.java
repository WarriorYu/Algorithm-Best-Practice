package playwithalgorithm.two;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/6/9
 * Describe : 选择排序  时间复杂度O(n^2)  空间复杂度O(1)   原地、不稳定排序。
 *  *
 *  * 概念：选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 *  * 不稳定排序：选择排序每次都要找剩余未排序元素中的最小值，并和前面的元素交换位置，这样破坏了稳定性。
 */
public class SelectionSort {
    //我们的算法类不允许产生任何实例
    private SelectionSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            // 寻找[i, n)区间里的最小值的索引
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            //将[i, n)区间里的最小值放在i的位置
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int minIndex) {
        Object temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
//        Integer[] array = SortTestHelper.generateRandomArray(10, 1, 10);
//        SelectionSort.sort(array);
//        SortTestHelper.printArray(so);
        // 测试Integer
       /* Integer[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();*/

        // 测试Double
        /*Double[] b = {4.4, 3.3, 2.2, 1.1};
        SelectionSort.sort(b);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();*/

        // 测试String
       /* String[] c = {"D", "C", "B", "A"};
        SelectionSort.sort(c);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
            System.out.print(' ');
        }
        System.out.println();*/

        // 测试自定义的类 Student
       /* Student[] d = new Student[4];
        d[0] = new Student("D", 90);
        d[1] = new Student("C", 100);
        d[2] = new Student("B", 95);
        d[3] = new Student("A", 95);
        SelectionSort.sort(d);
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }*/

        // 测试排序算法辅助函数
        /*int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SelectionSort.sort( arr );
        SortTestHelper.printArray(arr);*/

        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SelectionSort", arr);
    }

}
