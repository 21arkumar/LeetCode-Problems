class Solution {
    int[][] dp;
    public int helper(int[] prices, int day, int stock){
        if(day == prices.length) return 0;
        
        if(dp[stock][day] != -1){
            return dp[stock][day];
        }

        int skip = helper(prices, day+1, stock);
        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;

        if(stock == 0){
            buy = helper(prices, day+1, 1) - prices[day];
        }else{
            sell = helper(prices, day+1, 0) + prices[day];
        }

        dp[stock][day] = Math.max(skip, Math.max(buy, sell));
        return dp[stock][day];
    }

    public int maxProfit(int[] prices) {
        dp = new int[2][prices.length];
        
        for(int i = 0; i < 2; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(prices, 0, 0);
        
    }
}