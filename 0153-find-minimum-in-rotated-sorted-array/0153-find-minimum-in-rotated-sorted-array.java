class Solution {
    public int helper(int[] nums, int start, int end){
        if(start > end) return Integer.MAX_VALUE;
        
        int mid = (start + end)/2;
        if(start == end) return nums[mid];

        return Math.min(nums[mid], Math.min(helper(nums, start, mid-1), helper(nums, mid+1, end)));
    }
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
}