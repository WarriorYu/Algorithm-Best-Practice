package playwithdatastructures.union_find_11.quick_find_02;

import playwithdatastructures.union_find_11.UF;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/11/26
 * Describe :
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            //初始化，每个id[i]指向自己，没有合并的元素
            id[i] = i;
        }
    }
    @Override
    public int getSize() {
        return id.length;
    }

    // 查看元素p和元素q是否所属一个集合
    // O(1)复杂度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    // 查找元素p所对应的集合编号
    // O(1)复杂度
    private int find(int p) {
        if (p < 0 || p > id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }


    // 合并元素p和元素q所属的集合
    // O(n) 复杂度
    @Override
    public void unionElements(int p, int q) {
        int idP = find(p);
        int idQ = find(q);
        if (idP==idQ) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == idP) {
                id[i] = idQ;
            }
        }
    }
}
