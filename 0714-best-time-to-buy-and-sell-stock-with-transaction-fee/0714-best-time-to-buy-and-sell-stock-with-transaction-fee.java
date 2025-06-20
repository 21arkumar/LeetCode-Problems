class Solution {
    int[][] dp;
    public int helper(int[] prices, int stock, int days, int fee){
        if(days >= prices.length) return 0;
        
        if(dp[days][stock] != -1) return dp[days][stock];

        int skip = helper(prices, stock, days+1, fee);
        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;

        if(stock == 0){
            buy = helper(prices, 1, days+1, fee) - prices[days];
        }else{
            sell = helper(prices, 0, days+1, fee) + prices[days] - fee;
        }

        return dp[days][stock] = Math.max(skip, Math.max(buy, sell));
    }
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];

        for(int i = 0; i < prices.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(prices, 0, 0, fee);
    }
}