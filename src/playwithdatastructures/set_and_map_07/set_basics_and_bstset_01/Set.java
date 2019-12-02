package playwithdatastructures.set_and_map_07.set_basics_and_bstset_01;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/11/28
 * Describe :
 */
public interface Set<E> {
    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();
}
