package playwithdatastructures.union_find_11;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/11/26
 * Describe :
 */
public interface UF {
    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
