class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int n = prices.length;
        int maxProfit = 0;

        for(int i = 1; i < n; i++){
            if(prices[i] > buy){
                maxProfit = Math.max(maxProfit, prices[i]-buy);
            }else{
                buy = prices[i];
            }
        }

        return maxProfit;

    }
}