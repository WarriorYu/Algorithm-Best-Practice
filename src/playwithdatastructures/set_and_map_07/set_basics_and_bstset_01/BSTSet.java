package playwithdatastructures.set_and_map_07.set_basics_and_bstset_01;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/11/28
 * Describe : 基于二分搜索树的集合实现
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    //因为二分搜索树有比较，所以要继承Comparable

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<E>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
