package playwithdatastructures.segment_tree_09;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/24
 * Describe :
 */
public class Main {
    public static void main(String[] args) {
        // 基于数组实现的线段树
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
       /* SegmentTree<Integer> tree = new SegmentTree<Integer>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });*/
        //lambda版本
        SegmentTree<Integer> tree = new SegmentTree<Integer>(nums, (a, b) -> a + b);
        System.out.println(tree);
        //测试求线段树中一个区间范围的值
        System.out.println(tree.query(0, 2));
        System.out.println(tree.query(2, 5));
        System.out.println(tree.query(0, 5));
        System.out.println('I'+'T');

    }
}
