class Solution {
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            while(j < nums.length && nums[j] != 0) j++;
            if(nums[i] != 0 && i > j){
                swap(nums, i, j);
            }
        }
    }
}