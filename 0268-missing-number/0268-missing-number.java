class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum_till_n = (n*(n+1))/2;

        for(int i = 0; i < n; i++){
            sum_till_n -= nums[i];
        }

        return sum_till_n;
    }
}