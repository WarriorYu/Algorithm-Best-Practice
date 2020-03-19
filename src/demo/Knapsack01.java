package demo;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/3/18
 * Describe : 0-1背包问题
 */
public class Knapsack01 {
    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {1, 2, 3};
        int C = 5;
        int res = new Knapsack01().knapsack01(w, v, C);
        System.out.println(res);

    }

    /**
     * @param w 物品的重量
     * @param v 物品对应的价值
     * @param C 背包最大承重
     * @return
     */
    public int knapsack01(int[] w, int[] v, int C) {
        if (w == null || v == null || w.length != v.length) {
            throw new IllegalArgumentException("Invalid w or v ");
        }
        int n = w.length;
        if (C < 0) {
            throw new IllegalArgumentException("C must be greater or equals to zero");
        }
        if (n == 0 || C == 0) {
            return 0;
        }


        //方法一：时间复杂度（n*c）空间复杂度（n*c）
       /*
       int[][] memo = new int[n][C + 1];
       for (int j = 0; j <= C; j++) {
            //第一行，即第一个物品在背包为j重量时的价值
            memo[0][j] = (j >= w[0]) ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {

            for (int j = 0; j <= C; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i]) {
                    memo[i][j] = Math.max(memo[i][j], memo[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        return memo[n - 1][C];
*/

        //方法二：时间复杂度（2*c）空间复杂度（2*c）
        /*
        int[][] memo = new int[n][C + 1];
        for (int j = 0; j <= C; j++) {
            memo[0][j] = (j > w[0]) ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i%2][j] = memo[(i - 1)%2][j];
                if (j >= w[i]) {
                    memo[i%2][j] = Math.max(memo[i%2][j], memo[(i - 1)%2][j - w[i]] + v[i]);
                }
            }
        }

        return memo[(n - 1) % 2][C];
*/
        //方法三：时间复杂度（2*c）空间复杂度（2*c）
        int[] memo = new int[C + 1];
        for (int j = 0; j <= C; j++) {
            memo[j] = j >= w[0] ? w[0] : 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = C; j >= w[i]; j--) {
                memo[j] = Math.max(memo[j], memo[j - w[i]] + v[i]);
            }
        }
        return memo[C];
    }
}
