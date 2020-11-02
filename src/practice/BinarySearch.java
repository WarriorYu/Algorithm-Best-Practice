package practice;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/11/2
 * Describe : 二分查找
 */
public class BinarySearch {
    private BinarySearch() {
    }

    // 二分查找法,在有序数组arr中,查找target
    // 如果找到target,返回相应的索引index
    // 如果没有找到target,返回-1
    public static int find(Comparable[] arr, Comparable target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int middle = (r + l) / 2;
            if (arr[middle].compareTo(target) > 0) {
                r = middle - 1;
            } else if (arr[middle].compareTo(target) < 0) {
                l = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;

    }
}
