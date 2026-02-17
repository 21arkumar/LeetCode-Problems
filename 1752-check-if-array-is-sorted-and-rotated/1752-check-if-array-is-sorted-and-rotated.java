class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int drop = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]) drop++;
        }
        
        if(nums[0] < nums[n-1]) drop++;

        if(drop > 1) return false;

        return true;
    }
}