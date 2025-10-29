class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int cnt = 0;

        for(int i = 0; i < n; i++){
            int currSum = 0;
            for(int j = i; j < n; j++){
                currSum += nums[j];
                if(currSum == k){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}