class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne = 0;
        int tally = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                tally++;
            }else{
                tally = 0;
                continue;
            }
            maxOne = Math.max(maxOne, tally);
        }

        return maxOne;
    }
}