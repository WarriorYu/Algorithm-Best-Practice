/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/22
 * Describe : 基于数组实现的循环队列
 */
public class CircleQueue {
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private int[] items;

    public CircleQueue(int capacity) {
        items = new int[capacity];
        size = capacity;
    }

    public boolean enqueue(int item) {
        if ((tail + 1) % size == head) {
            //队列满了
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % size;
        return true;
    }

    public int dequeue() {
        if (head  == tail) {
            //队列为空了
            return -1;
        }
        int ret = items[head];
        head = (head + 1) % size;
        return ret;
    }

    public void printAll() {
        if (size==0) return;
        for (int i = head; i % size != tail; i++) {
            System.out.print(items[i%size]+" ");
        }
    }

    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(5);
        for (int i = 0; i < 4; i++) {
            queue.enqueue(i);
        }
        queue.printAll();
        System.out.println();
        queue.dequeue();
        queue.dequeue();
        queue.printAll();
        System.out.println();
        for (int i = 4; i < 9; i++) {
            queue.enqueue(i);
        }
        queue.printAll();
    }
}
