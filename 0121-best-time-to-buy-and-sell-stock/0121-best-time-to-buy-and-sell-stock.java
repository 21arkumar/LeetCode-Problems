class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], sell = prices[0];
        int n = prices.length;
        int maxProfit = sell - buy;

        for(int i = 1; i < n; i++){
            if(prices[i] < buy){
                buy = prices[i];
                sell = buy;
            }else{
                sell = prices[i];
                maxProfit = Math.max(maxProfit, sell-buy);
            }
        }

        return maxProfit;

    }
}