package playwithdatastructures.segment_tree_09;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/24
 * Describe :
 */
public interface Merger<E> {
    E merge(E a, E b);
}
