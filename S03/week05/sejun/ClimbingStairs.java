// 0ms Beats 100.00% of users with Java
// Memory 40.10MB Beats 73.81% of users with Java
class Solution {
    int[] dp = new int[46];
    public int climbStairs(int n) {
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int oneStep = dp[i-1];
            int twoStep = 0;
            if (i -2 >= 0) {
                twoStep = dp[i-2];
            }

            dp[i] = oneStep + twoStep;
        }

        return dp[n];
    }
}
