package playwithdatastructures.hash_table_14;

import java.time.temporal.ValueRange;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/5
 * Describe :
 */
public class HashTable<K, V> {
    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;


    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<K, V>();
        }
    }

    public HashTable() {
        this(97);
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
            if (size >= upperTol * M) {
                resize(2 * M);
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
            if (size < lowerTol * M && M / 2 >= initCapacity) {
                resize(M / 2);
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
