package playwithdatastructures.hash_table_14.more_about_resizeing_in_hash_table_07;

import java.util.TreeMap;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/5
 * Describe :
 */
public class HashTable2<K, V> {
    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};
    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private int capacityIndex = 0;


    public HashTable2() {
        this.M = capacity[capacityIndex];
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<K, V>();
        }
    }

    public int getSize() {
        return size;
    }

    private int hash(K key) {
        return (key.hashCode() & 0X7fffffff) % M;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
            //扩容
            if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap();
        }
        int oldM = M;
        M = newM;//更新M,否则扩容后hash()值不对
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashTable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        this.hashTable = newHashTable;
    }

    public V remove(K key) {
        V ret = null;
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            //缩容
            if (size < lowerTol * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            throw new IllegalArgumentException(key + "dons't exist!");
        }
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }
}
