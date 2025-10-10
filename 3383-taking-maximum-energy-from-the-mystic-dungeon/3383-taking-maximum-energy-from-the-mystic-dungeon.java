class Solution {
    int[] dp;
    public int helper(int[] energy, int k, int indx){
        if(indx >= energy.length){
            return 0;
        }

        if(dp[indx] != -1) return dp[indx];

        return dp[indx] = (energy[indx] + helper(energy, k, indx + k));
    }
    public int maximumEnergy(int[] energy, int k) {
        int maxValue = Integer.MIN_VALUE;
        
        dp = new int[energy.length];
        Arrays.fill(dp, -1);

        for(int i = 0; i < energy.length; i++){
            maxValue = Math.max(maxValue, helper(energy, k, i));
        }
        return maxValue;
    }
}