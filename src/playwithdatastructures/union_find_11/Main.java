package playwithdatastructures.union_find_11;

import playwithdatastructures.union_find_11.more_about_union_find_07.UnionFind6;
import playwithdatastructures.union_find_11.optimized_by_rank_05.UnionFind4;
import playwithdatastructures.union_find_11.path_compression_06.UnionFind5;
import playwithdatastructures.union_find_11.quick_find_04.UnionFind3;

import java.util.Random;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/11/26
 * Describe :
 */
public class Main {
    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;
       /* UnionFind1 find1 = new UnionFind1(size);
        System.out.println("UnionFind1 : "+testUF(find1,m)+"s");

        UnionFind2 find2 = new UnionFind2(size);
        System.out.println("UnionFind2 : "+testUF(find2,m)+"s");*/

        UnionFind3 find3 = new UnionFind3(size);
        System.out.println("UnionFind3 : "+testUF(find3,m)+"s");

        UnionFind4 find4 = new UnionFind4(size);
        System.out.println("UnionFind4 : "+testUF(find4,m)+"s");

        UnionFind5 find5 = new UnionFind5(size);
        System.out.println("UnionFind5 : "+testUF(find5,m)+"s");

        UnionFind6 find6 = new UnionFind6(size);
        System.out.println("UnionFind6 : "+testUF(find6,m)+"s");

    }

    public static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


}
