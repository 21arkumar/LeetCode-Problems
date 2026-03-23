class Solution {
    public int maxSubArray(int[] nums) {
        int start = 0, end = 0;
        int n = nums.length;
        int maxSum = nums[0];
        
        while(start < n){
            int currSum = 0;

            while(end < n){
                currSum += nums[end];
                maxSum = Math.max(currSum, maxSum);
                end++;

                if(currSum < 0){
                    break;
                }
            }

            start = end;
        }

        return maxSum;
    }
}