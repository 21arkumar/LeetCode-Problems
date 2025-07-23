class Solution {
    int[][] dp;
    int offset = 1000;

    public int helper(int[] nums, int target, int index, int sum){
        if(index >= nums.length && sum == target) return 1;
        if(index >= nums.length && sum != target) return 0;

        if(dp[index][sum + offset] != -1) {
            return dp[index][sum + offset];
        }

        int pos = helper(nums, target, index + 1, sum + nums[index]);
        int neg = helper(nums, target, index + 1, sum + (-1 * nums[index]));
        
        return dp[index][sum + offset] = pos+neg;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        dp = new int[n][2001]; 
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(nums, target, 0, 0);
    }
}