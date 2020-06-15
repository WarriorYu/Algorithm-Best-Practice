package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/5/2
 * Describe : 435. 无重叠区间
 */
class Lc_435 {
    // public static class Interval{
    //     int start;
    //     int end;
    //     Interval(){
    //         start = 0;
    //         end = 0;
    //     }
    //     Interval(int s,int e){
    //         start = s;
    //         end = e;
    //     }
    // }

    public static int eraseOverlapIntervals(int[][] intervals) {
        //动态规划
        if(intervals.length == 0){
            return 0;
        }

        //对数组排序，
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                // 先比较end,end小的在前面，
                if(o1[1] != o2[1]){
                    return o1[1] - o2[1];
                }else{
                    //如果end相等，然后比较start,start小的在前面
                    return o1[0] - o2[0];
                }
            }
        });

        int[] memo = new int[intervals.length];
        Arrays.fill(memo,1);

        for(int i=1;i<intervals.length;i++){
            for(int j =0;j<i;j++){
                //如果i的start大于j的end，则是不重叠的，+1
                if(intervals[i][0]>=intervals[j][1]){
                    memo[i] = Math.max(memo[i],1+memo[j]);
                }
            }
        }
        int res = 0;
        for(int i=0;i<memo.length;i++){
            res = Math.max(res,memo[i]);
        }

        return intervals.length - res;

    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}