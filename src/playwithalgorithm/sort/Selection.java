package playwithalgorithm.sort;

/**
 * 查找数组中的第k大元素
 */
public class Selection {
    public static void main(String[] args) {
        Comparable[] arr = {1, 7, 2, 5, 9, 7, 8, 6};
        Comparable result = new Selection().solve(arr, 3);
        System.out.println(result);

    }
    public Comparable solve(Comparable[] arr, int k) {
        int n = arr.length;
        return sort(arr, 0, n - 1, k-1);
    }

    private Comparable sort(Comparable[] arr, int l, int r, int k) {
        if (l >= r) return arr[l];

        int p = partition(arr, l, r);
        if (p == k) {
            return arr[p];
        } else if (p > k) {
            return sort(arr, l, p - 1, k);
        } else {
            return sort(arr, p + 1, r, k);
        }
    }

    private int partition(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = arr[l]; //使用第一个元素作为分区点
        int j = l;//arr[l+1...j] < v; arr[j+1,i) >v;
        for (int i = l+1; i <= r; i++) {
            if (arr[i].compareTo(v)<0){
                j++;
                swap(arr,i,j);
            }
            //如果arr[i].compareTo(v)>0 自动i++l了，其他的不用动
        }
        //将分区点v和j位置的元素交换
        swap(arr,l,j);
        return j;
    }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
