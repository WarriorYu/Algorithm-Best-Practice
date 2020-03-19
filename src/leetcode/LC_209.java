package leetcode;

import java.util.HashMap;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/31
 * Describe : 209. 长度最小的子数组
 */
public class LC_209 {


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 16;
//        System.out.println(minSubArrayLen(s, nums));
        System.out.println(lengthOfLongestSubstring( "abc" ));

    }

    public static int minSubArrayLen(int s, int[] nums) {
        if(s<=0||nums==null){
            throw new IllegalArgumentException("Illegal argument");
        }

        int l=0,r=-1;//nums[l...r]是滑动窗口
        int sum =0;
        int res = nums.length+1;
        while(l<nums.length){
            if(sum<s){
                if(r+1<nums.length){
                    sum+=nums[++r];
                }else{
                    break;
                }
            }else{
                sum -=nums[l++];
            }
            if(sum>=s){
                res = Math.min(res,r-l+1);
            }
        }
        if(res==nums.length+1){
            return 0;
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        int l=0,r=-1;
        int[] freq = new int[256];
        int res = 0;
        while(l<s.length()){
            if(r+1<s.length() && freq[s.charAt(r+1)]==0){
                freq[s.charAt(++r)]++;
            }else{//r已经到头 || freq[s[r+1]] == 1
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res,r-l+1);
        }

        return res;
    }
}
