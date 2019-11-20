package playwithdatastructures.segment_tree_09;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/25
 * Describe :
 */
public class NumArray {

    private  SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length != 0) {
            Integer[] arr = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arr[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(arr, new Merger<Integer>() {
                @Override
                public Integer merge(Integer a, Integer b) {
                    return a + b;
                }
            });
        }
    }

    public void update(int i, int val) {
        if (segmentTree==null) {
            throw new IllegalArgumentException("Error");
        }
        segmentTree.set(i,val);
    }

    public int sumRange(int i, int j) {
        if (segmentTree==null) {
            throw new IllegalArgumentException("Error");
        }
        return segmentTree.query(i, j);
    }
}
