class Solution {
    int[] dp;
    public int helper(int[] nums, int index){
        if(index >= nums.length) return 0;

        if(dp[index] != -1){
            return dp[index];
        }

        int rob = nums[index] + helper(nums, index + 2);
        int skip = helper(nums, index + 1);

        return dp[index] = Math.max(rob, skip);
    }
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int maxMoney = 0;

        for(int i = 0; i < nums.length; i++){
            maxMoney = Math.max(maxMoney, helper(nums, i));
        }

        return maxMoney;
    }
}