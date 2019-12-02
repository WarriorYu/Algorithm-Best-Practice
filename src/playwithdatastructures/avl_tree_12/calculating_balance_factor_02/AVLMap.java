package playwithdatastructures.avl_tree_12.calculating_balance_factor_02;

import playwithdatastructures.set_and_map_07.linkedlistmap_06.Map;

import java.util.Comparator;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/2
 * Describe :
 */
public class AVLMap<K extends Comparable<K>,V> implements Map<K,V> {

    private final AVLTree<K, V> avlTree;

    public AVLMap() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        avlTree.add(key,value);

    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        avlTree.set(key,newValue);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
