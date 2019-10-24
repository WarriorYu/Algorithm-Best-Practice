package playwithdatastructures.heap_and_priority_queue_08;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/23
 * Describe :
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();


}
