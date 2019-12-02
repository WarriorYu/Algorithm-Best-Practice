package playwithdatastructures.avl_tree_12.calculating_balance_factor_02;

import playwithdatastructures.set_and_map_07.set_basics_and_bstset_01.Set;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/2
 * Describe :
 */
public class AVLSet<K extends Comparable<K>> implements Set<K> {

    private final AVLTree<K, Object> avlTree;

    public AVLSet() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(K k) {
        avlTree.add(k, null);
    }

    @Override
    public boolean contains(K k) {
        return avlTree.contains(k);
    }

    @Override
    public void remove(K k) {
        avlTree.remove(k);
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
