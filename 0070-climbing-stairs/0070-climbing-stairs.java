class Solution {
    public int helper(int n, int[] dp){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(dp[n-1] != 0) return dp[n-1];
        return dp[n-1] = helper(n - 1, dp) + helper(n - 2, dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n];
        return helper(n, dp);
    }
}