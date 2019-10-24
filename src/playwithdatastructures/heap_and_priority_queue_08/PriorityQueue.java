package playwithdatastructures.heap_and_priority_queue_08;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/23
 * Describe :
 */
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
