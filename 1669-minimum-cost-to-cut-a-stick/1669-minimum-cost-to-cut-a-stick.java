class Solution {
    int[][] dp;
    public int helper(int[] cuts, int i, int j, int left, int right){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            minCost = Math.min(minCost, helper(cuts, i, k, left, cuts[k]) + helper(cuts, k+1, j, cuts[k], right) + (right - left));
        }

        return dp[i][j] = minCost;
    }
    public int minCost(int n, int[] cuts) {
        dp = new int[cuts.length+1][cuts.length+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        Arrays.sort(cuts);
        return helper(cuts, 0, cuts.length, 0, n);
    }
}