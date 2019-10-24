package demo;

import java.util.*;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/8/20
 * Describe :
 */
public class HashMapDemo {
    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("苹果", 1);
        map.put("香蕉", 2);
        map.put("西瓜", 3);
        map.put("菠萝", 4);





        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }

        System.out.println();

        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
        System.out.println();



        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " = " + map.get(key));
        }

        System.out.println();

        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
        }

        Object o = new Object();
        o.hashCode();
        Float.isNaN(3);

    }
}
