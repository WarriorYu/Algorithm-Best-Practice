/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/22
 * Describe :
 */
public class QueueBasedOnLinkedList {

    private Node head;
    private Node tail;


    private QueueBasedOnLinkedList() {
        this.head = null;
        this.tail = null;
    }

    private boolean enqueue(String item) {
        if (head == null && tail == null) {
            //空链表
            head = tail = new Node(item, null);
//            tail = tail.next;
        } else {
            tail.next = new Node(item, null);
            tail = tail.next;
        }
        return true;
    }

    private String dequeue() {
        if (head == null) {
            //链表为空了
            return null;
        }
        String ret = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return ret;
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data+" ");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        for (int i = 0; i < 4; i++) {
            queue.enqueue(String.valueOf(i));
        }
        queue.printAll();
        System.out.println();
        queue.dequeue();
        queue.dequeue();
        queue.printAll();
        System.out.println();
        for (int i = 4; i < 8; i++) {
            queue.enqueue(String.valueOf(i));
        }
        queue.printAll();
    }

}
