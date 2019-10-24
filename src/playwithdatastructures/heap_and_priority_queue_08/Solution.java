package playwithdatastructures.heap_and_priority_queue_08;

import java.util.*;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/23
 * Describe :
 */
public class Solution {
    public class Array<E> {


        private E[] data;
        private int size;

        // 构造函数，传入数组的容量capacity构造Array
        public Array(int capacity) {
            data = (E[]) new Object[capacity];
            size = 0;
        }

        // 无参数的构造函数，默认数组的容量capacity=10
        public Array() {
            this(10);
        }

        // 获取数组的容量
        public int getCapacity() {
            return data.length;
        }

        // 获取数组中的元素个数
        public int getSize() {
            return size;
        }

        // 返回数组是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        // 在index索引的位置插入一个新元素e
        public void add(int index, E e) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Add failed,Requir index>=0 and index<=size");
            }
            if (size == data.length) {
                //需要扩容
                resize(2 * data.length);
            }
            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = e;
            size++;
        }

        // 向所有元素后添加一个新元素
        public void addLast(E e) {
            add(size, e);
        }

        // 在所有元素前添加一个新元素
        public void addFirst(E e) {
            add(0, e);
        }

        // 获取index索引位置的元素
        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Get failed,Index is illegal.");
            }
            return data[index];
        }

        // 修改index索引位置的元素为e
        public void set(int index, E e) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Set failed,Index is illegal.");
            }
            data[index] = e;
        }

        // 查找数组中是否有元素e
        public boolean contains(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return true;
                }
            }
            return false;
        }

        // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
        public int find(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return i;
                }
            }
            return -1;
        }

        // 从数组中删除index位置的元素, 返回删除的元素
        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Remove failed,Require index>=0 and index<size");
            }
            E ret = data[index];
            for (int i = index + 1; i < size; i++) {
                data[i - 1] = data[i];
            }
            size--;
            data[size] = null;

            if (size == data.length / 4 && data.length / 2 != 0) {
                //当数组中的数据等于数组容量的四分之一时，缩容一半
                resize(data.length / 2);
            }
            return ret;
        }

        // 从数组中删除第一个元素, 返回删除的元素
        public E removeFirst() {
            return remove(0);
        }

        // 从数组中删除最后一个元素, 返回删除的元素
        public E removeLast() {
            return remove(size - 1);
        }

        // 从数组中删除元素e
        public void removeElement(E e) {
            int index = find(e);
            remove(index);
        }

        public void swap(int i, int j) {
            if (i < 0 || i >= size || j < 0 || j >= size) {
                throw new IllegalArgumentException("Index is illegal");
            }
            E temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
            builder.append("[");
            for (int i = 0; i < size; i++) {
                builder.append(data[i]);
                if (i != size - 1) {
                    builder.append(", ");
                }
            }
            builder.append("]");
            return builder.toString();
        }

        // 将数组空间的容量变成newCapacity大小
        private void resize(int newCapacity) {
            E[] newData = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }

    }

    public class MaxHeap<E extends Comparable> {

        private Array<E> data;

        public MaxHeap(int capacity) {
            data = new Array<>(capacity);
        }

        public MaxHeap() {
            data = new Array<>();

        }

        // 返回堆中的元素个数
        public int size() {
            return data.getSize();
        }

        // 返回一个布尔值, 表示堆中是否为空
        public boolean isEmpty() {
            return data.isEmpty();
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
        private int parent(int index) {
            if (index == 0) {
                throw new IllegalArgumentException("index-0 doesn't have parent");
            }
            return (index - 1) / 2;
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
        private int leftChild(int index) {
            return index * 2 + 1;
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
        private int rightChild(int index) {
            return index * 2 + 2;
        }

        //向堆中添加元素
        public void add(E e) {
            data.addLast(e);
            siftUp(data.getSize() - 1);
        }

        public void siftUp(int k) {

            while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
                //先交换
                data.swap(parent(k), k);
                //如果不是堆顶，并且父节点小于子节点，则继续往上堆化
                k = parent(k);
            }
        }

        //看堆中的最大元素
        public E findMax() {
            if (data.getSize() == 0) {
                throw new IllegalArgumentException("Can't findMax when heap is empty");
            }
            return data.get(0);
        }

        //取出堆中的最大元素
        public E extractMax() {
            E ret = findMax();
            //先把堆顶元素和最后一个元素交换
            data.swap(0, data.getSize() - 1);
            //删除最后一个元素
            data.removeLast();
            //堆顶元素往下堆化，遇到大的就交换位置
            siftDown(0);
            return ret;
        }

        //往下堆化
        private void siftDown(int k) {
            while (leftChild(k) < data.getSize()) {
                int j = leftChild(k);
                if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) < 0) {
                    j++;
                }
                if (data.get(k).compareTo(data.get(j)) >= 0) {
                    break;
                }
                data.swap(k, j);
                k = j;
            }
        }

    }

    private class Freq implements Comparable<Freq> {

        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return 1;
            else if (this.freq > another.freq)
                return -1;
            else
                return 0;
        }
    }

    public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

        private final MaxHeap<E> maxHeap;

        public PriorityQueue() {
            maxHeap = new MaxHeap<>();
        }

        @Override
        public int getSize() {
            return maxHeap.size();
        }

        @Override
        public boolean isEmpty() {
            return maxHeap.isEmpty();
        }

        @Override
        public void enqueue(E e) {
            maxHeap.add(e);
        }

        @Override
        public E dequeue() {
            return maxHeap.extractMax();
        }

        @Override
        public E getFront() {
            return maxHeap.findMax();
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        /*HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });


        for (Integer key : map.keySet()) {
            heap.add(map.get(key));
            if (heap.size()> k) {
                heap.poll();
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
        Collections.reverse(list);
*/


        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        /*MaxHeap<Freq> maxHeap = new MaxHeap<>();
        for (int key : map.keySet()) {
            if (maxHeap.size() < k)
                maxHeap.add(new Freq(key, map.get(key)));
            else if (map.get(key) > maxHeap.findMax().freq) {
                maxHeap.extractMax();
                maxHeap.add(new Freq(key, map.get(key)));
            }
        }*/
        //使用优先级队列实现
        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if (queue.getSize() < k) {
                queue.enqueue(new Freq(key, map.get(key)));
            } else if (queue.getFront().freq < map.get(key)) {
                queue.dequeue();
                queue.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty())
            res.add(queue.dequeue().e);
        return res;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution()).topKFrequent(nums, k));

    }

}