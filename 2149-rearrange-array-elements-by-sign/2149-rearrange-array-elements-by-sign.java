class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int x = 0, y = 1;

        for(int i = 0; i < n; i++){
            if(nums[i] >= 0){
                ans[x] = nums[i];
                x += 2;
            }else{
                ans[y] = nums[i];
                y += 2;
            }
        }

        return ans;

    }
}