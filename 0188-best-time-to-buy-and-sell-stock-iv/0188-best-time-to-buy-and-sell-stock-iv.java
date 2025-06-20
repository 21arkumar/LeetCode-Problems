class Solution {
    int[][][] dp;
    public int helper(int[] prices, int day, int stock, int trans, int k){
        if(trans > k) return 0;
        if(day == prices.length) return 0;
        
        if(dp[stock][day][trans] != -1) return dp[stock][day][trans];

        int skip = helper(prices, day+1, stock, trans, k);
        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;

        if(stock == 0){
            buy = helper(prices, day+1, 1, trans+1, k) - prices[day];
        }else{
            sell = helper(prices, day+1, 0, trans, k) + prices[day];
        }

        return dp[stock][day][trans] = Math.max(skip, Math.max(buy, sell));
    }
    public int maxProfit(int k, int[] prices) {
        dp = new int[2][prices.length][k+1];

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < prices.length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(prices, 0, 0, 0, k);
    }
}