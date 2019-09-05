/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/6/3
 * Describe : 4种常见的二分查找变形问题 (有序数据集合中存在重复的数据)
 */
public class BSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 5, 7, 9, 9, 10, 12};
//        int index = bsearch(arr, arr.length, 9);
//        int index = bsearch2(arr, arr.length, 9);
//        int index = bsearch3(arr, arr.length, 3);
        int index = bsearch4(arr, arr.length, 9);



        System.out.print(index);
    }

    /**
     * 变体一：查找第一个值等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch(int[] a, int n, int value) {
        if (n == 0) return -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return -1;
    }

    /**
     * 变体二：查找最后一个值等于给定值的元素
     */
    public static int bsearch2(int[] a, int n, int value) {
        if (n == 0) return -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                if (mid == n - 1 || a[mid + 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 变体三：查找第一个大于等于给定值的元素
     */
    public static int bsearch3(int[] a, int n, int value) {
        if (n == 0) return -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变体四：查找最后一个小于等于给定值的元素
     */
    public static int bsearch4(int[] a, int n, int value) {
        if (n == 0) return -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                if (mid == n - 1 || a[mid + 1] > value) return mid;
                else low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}