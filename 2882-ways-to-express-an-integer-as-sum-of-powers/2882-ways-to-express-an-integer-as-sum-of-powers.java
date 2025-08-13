class Solution {
    static int MOD = 1000000007;
    int[][] dp;
    int helper(int n, int index, int x){
        int power = (int) Math.pow(index, x);
        if(n == 0 || n == power) return 1;
        if(power > n) return 0;
        if(dp[n][index] != -1){
            return dp[n][index];
        }
        int take = helper(n - power, index + 1, x);
        int notTake = helper(n, index + 1, x);
        return dp[n][index] = (take + notTake) % MOD;
    }
    public int numberOfWays(int n, int x) {
        dp = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return helper(n, 1, x);
    }
}