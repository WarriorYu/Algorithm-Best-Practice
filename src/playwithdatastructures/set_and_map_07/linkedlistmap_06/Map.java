package playwithdatastructures.set_and_map_07.linkedlistmap_06;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/11/28
 * Describe :
 */
public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key,V newValue);

    int getSize();

    boolean isEmpty();
}
