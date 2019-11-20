package playwithdatastructures.segment_tree_09;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/24
 * Describe : 线段树
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;

        buildSegmentTree(leftChildIndex, l, mid);
        buildSegmentTree(rightChildIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    public int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    public int rightChild(int index) {
        return index * 2 + 2;
    }

    //返回区间[queryL,queryR]的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //在以treeIndex为根的线段树中[l...r]范围内搜索区间[queryL...queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        //如果所求区间就是treeIndex对应的区间，直接返回treeIndex的值
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        //如果要查找的区间范围都在treeIndex的右子节点中
        if (queryL >= mid + 1) {
            return query(rightChild(treeIndex), mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            //如果要查找的区间范围都在treeIndex的左子节点中
            return query(leftChild(treeIndex), l, mid, queryL, queryR);
        }
        //如果要查找的区间范围在treeIndex的左子节点和右子节点中都有元素,则分别求左右子节点内的元素之和
        E leftChild = query(leftChild(treeIndex), l, mid, queryL, mid);
        E rightChild = query(rightChild(treeIndex), mid + 1, r, mid + 1, queryR);
        return merger.merge(leftChild, rightChild);
    }

    // 将index位置的值，更新为e
    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    //在以treeIndex为根节点的线段树中更新index的值为e
    private void set(int treeIndex, int l, int r, int index, E e) {
        //如果treeIndex 位置的元素就是数组data中index位置的元素，直接更新，说明从根节点到叶子节点都已经更新完毕
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index >= mid + 1) {
            //index在treeIndex的右子节点范围内
            set(rightTreeIndex, mid + 1, r, index, e);
        } else {//index <= mid
            //index在treeIndex的左子节点范围内
            set(leftTreeIndex, l, mid, index, e);
        }

        //将左右子树更改值后，更新treeIndex中的值
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                builder.append(tree[i]);
            } else {
                builder.append("null");
            }
            if (i != tree.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
