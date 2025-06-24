class Solution {
    int[][] dp;
    int helper(int[] nums, int i, int prev){
        if(i == nums.length) return 0;
        
        if(dp[i][prev+1] != -1) return dp[i][prev+1];

        int len = 0 + helper(nums, i+1, prev);

        if((prev == -1) || (nums[i] > nums[prev])){
            len = Math.max(len, 1+ helper(nums, i+1, i));
        }

        return dp[i][prev+1] = len;
    }
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length+1];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(nums, 0, -1);
    }
}