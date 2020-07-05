package playwithalgorithm.four;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/6/16
 * Describe : 最大堆的实现
 */
public class MaxHeap<Item extends Comparable> {
    private int capacity;//最大容量
    private int count;//MaxHeap中实际的容量
    private Item[] data;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];//因为第0个位置不放元素，索引从1开始的，所以这里capacity+1
        count = 0;
        this.capacity = capacity;
    }

    // 构造函数, 通过一个给定数组创建一个最大堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MaxHeap(Item arr[]) {
        int n = arr.length;
        data = (Item[]) new Comparable[n + 1];
        this.capacity = n;

        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    /**
     * 返回堆中的元素个数
     *
     * @return
     */
    public int size() {
        return count;
    }


    /**
     * 返回一个布尔值, 表示堆中是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Item item) {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    /**
     * 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
     *
     * @return
     */
    public Item extractMax() {
        assert count > 0;
        //取出最大元素
        Item ret = data[1];
        //将堆顶元素放到最后一个，最后一个元素放到堆顶。
        swap(1, count);
        //数量减一，因为堆顶元素放到了最后，相当于删除了一个堆顶元素
        count--;
        //然后往下堆化
        shiftDown(1);

        return ret;
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            //找出k元素的左右子节点的最大值，然后和最大值交换
            if ((j + 1) <= count && data[j].compareTo(data[j + 1]) < 0) {
                // data[j] 是 data[2*k]和data[2*k+1]中的最大值
                j++;
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    /**
     * 获取最大堆中的堆顶元素
     *
     * @return
     */
    public Item getMax() {
        assert count > 0;
        return data[1];
    }

    /**
     * 往上堆化
     * 最大堆核心辅助函数
     *
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void swap(int a, int b) {
        Item temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    // 测试 MaxHeap
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for (int i = 0; i < N; i++)
            maxHeap.insert(new Integer((int) (Math.random() * M)));

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for (int i = 0; i < N; i++) {
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for (int i = 1; i < N; i++)
            assert arr[i - 1] >= arr[i];
    }
}
