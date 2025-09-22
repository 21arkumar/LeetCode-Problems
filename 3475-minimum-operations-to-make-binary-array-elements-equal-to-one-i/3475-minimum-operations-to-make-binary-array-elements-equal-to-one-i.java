class Solution {
    public int minOperations(int[] nums) {
        int i = 0, j = i + 2;
        int mask = 1;
        int count = 0;
        while(j < nums.length){
            if(nums[i] == 0){
                for(int k = i; k <= j; k++){
                    nums[k] = nums[k] ^ mask; 
                }
                count++;
            }
            i++;
            j++;
        }
        if(nums[nums.length-1] == 0 || nums[nums.length-2] == 0){
            return -1;
        }else{
            return count;
        }
    }
}