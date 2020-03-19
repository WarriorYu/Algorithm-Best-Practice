package leetcode;

import java.util.Arrays;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/3/11
 * Describe :
 */
public class LC_91 {

    private int n;
    private int[] dp;
    public int numDecodings(String s) {
        n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(s,0);
    }

    public int dfs(String s,int start){
        if(start >=n) return 1;
        if(s.charAt(start) == '0') return 0;
        if(dp[start] != -1) return dp[start];

        int res = dfs(s,start+1);
        if(start+1 < n && Integer.valueOf(s.substring(start,start+2)) <= 26){
            res += dfs(s,start+2);
        }
        return dp[start] = res;
    }

    public static void main(String[] args) {
        int num = new LC_91().numDecodings("226");
        System.out.println(num);
    }
}
