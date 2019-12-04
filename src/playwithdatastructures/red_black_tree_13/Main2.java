package playwithdatastructures.red_black_tree_13;

import playwithdatastructures.avl_tree_12.calculating_balance_factor_02.AVLTree;
import playwithdatastructures.avl_tree_12.calculating_balance_factor_02.BSTMap;

import java.util.ArrayList;
import java.util.Random;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/4
 * Describe :
 */
public class Main2 {
    public static void main(String[] args) {
        // int n = 20000000;
        int n = 20000000;

        Random random = new Random(n);
        ArrayList<Integer> testData = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i ++)
//            testData.add(random.nextInt(Integer.MAX_VALUE));
            testData.add(i);


        // Test BST
//        long startTime = System.nanoTime();
//
//        BSTMap<Integer, Integer> bst = new BSTMap<>();
//        for (Integer x: testData)
//            bst.add(x, null);
//
//        long endTime = System.nanoTime();
//
//        double time = (endTime - startTime) / 1000000000.0;
//        System.out.println("BST: " + time + " s");


        // Test AVL
        long startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x: testData)
            avl.add(x, null);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");


        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x: testData)
            rbt.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");
    }
}
