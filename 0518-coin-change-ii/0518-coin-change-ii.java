class Solution {
    public int change(int amount, int[] coins) {
        long[] dp = new long[amount+1];
        Arrays.fill(dp, 0);

        dp[0] = 1;

        for(int coin : coins){
            for(int i = coin; i < amount + 1; i++){
                dp[i] += dp[i-coin];
            }
        }

        return (int)dp[amount];
    }
}