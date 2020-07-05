/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/6/3
 * Describe : 二分查找  （数组必须有序，不存在重复）
 */
public class BinaryFind {
    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 5, 7, 9, 10, 12};
        int index = bsearch(arr, arr.length, 9);
        System.out.print(index);


    }


    //mid=(low+high)/2 这种写法是有问题的。
    // 因为如果 low 和 high 比较大的话，两者之和就有可能会溢出。
    // 改进的方法是将 mid 的计算方式写成 low+(high-low)/2。
    // 更进一步，如果要将性能优化到极致的话，我们可以将这里的除以 2 操作转化成位运算 low+((high-low)>>1)。
    // 因为相比除法运算来说，计算机处理位运算要快得多。
    public static int bsearch(int[] a, int n, int value) {
        if (n == 0) return -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return -1;

    }
}
