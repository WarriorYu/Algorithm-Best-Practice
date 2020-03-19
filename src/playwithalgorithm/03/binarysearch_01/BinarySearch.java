/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/18
 * Describe : 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {

        int n = (int) Math.pow(10, 7);
        Integer data[] = Util.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
           /* if(i != binarySearch(data, n, i))
                throw new IllegalStateException("find i failed!");*/
            if (i != binarySearch2(data, n, i))
                throw new IllegalStateException("find i failed!");
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + " ms");

    }

    private static int binarySearch(Comparable[] data, int n, Comparable target) {
        int l = 0, r = n - 1;

        while (l <= r) {//在[l...r]里查找target
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            } else if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }


    private static int binarySearch2(Comparable[] data, int n, Comparable target) {
        int l = 0, r = n;//在[l...r)里查找target

        while (l < r) {//当l==r时，[l...r)是一个无效区间
            int mid = l + (r - l) / 2;//防止整型溢出
            if (data[mid].compareTo(target) == 0) {
                return mid;
            } else if (data[mid].compareTo(target) < 0) {
                l = mid + 1;// target在[mid+1...r)中; [l...mid]一定没有target
            } else {
                r = mid;// target在[l...mid)中; [mid...r)一定没有target
            }
        }
        return -1;
    }
}
