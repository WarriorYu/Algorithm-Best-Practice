/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/22
 * Describe : 基于数组实现的链表
 */
public class ArrayQueue {

    private String[] items;
    //队头下标
    private int head = 0;
    //队尾小标
    private int tail = 0;

    private int size = 0;


    public ArrayQueue(int capacity) {
        items = new String[capacity];
        size = capacity;
    }

    //入队
    public boolean enqueue(String item) {
        if (tail == size) {
            //整个队列满了
            if (head == 0) {
                return false;
            }
            //数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    //出队
    public String dequeue() {
        //队列为空
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head++;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        for (int i = 0; i < 3; i++) {
            queue.enqueue(String.valueOf(i));
        }
        queue.printAll();
        System.out.println();

        queue.dequeue();
        queue.dequeue();
        queue.printAll();
        System.out.println();

        queue.enqueue("哈哈");
        queue.enqueue("xixi");
        queue.printAll();
    }
}
