class Solution {
    int[][] dp;
    public int helper(int[] prices, int stock, int days){
        if(days >= prices.length) return 0;
        
        if(dp[days][stock] != -1) return dp[days][stock];

        int skip = helper(prices, stock, days+1);
        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;

        if(stock == 0){
            buy = helper(prices, 1, days+1) - prices[days];
        }else{
            sell = helper(prices, 0, days+2) + prices[days];
        }

        return dp[days][stock] = Math.max(skip, Math.max(buy, sell));
    }
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];

        for(int i = 0; i < prices.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(prices, 0, 0);
    }
}