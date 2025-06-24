class Solution {
    public int jump(int[] nums) {
        int currEnd = 0;
        int currFarEnd = 0;
        int jump = 0;
        if(nums.length == 1) return 0;
        for(int i = 0; i < nums.length; i++){
            currFarEnd = Math.max(currFarEnd, nums[i]+i);
            if(i == currEnd){
                currEnd = currFarEnd;
                jump++;

                if(currFarEnd >= nums.length - 1) break;
            }
        }
        return jump;
    }
}