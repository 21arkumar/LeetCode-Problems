class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] map = new int[n];

        left[0] = 0;
        right[n-1] = 0;
        
        for(int i = 1; i < n-1; i++){
            //left array
            left[i] = (nums[i-1] != nums[i]) ? nums[i-1] : left[n-1];
            //right array
            right[n-i-1] = (nums[n-i-1] != nums[n-i]) ? nums[n-i] : right[n-i];
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(left[i] == 0 || right[i] == 0){
                map[i] = -1;
                continue;
            }else if(nums[i] > left[i] && nums[i] > right[i]){
                map[i] = 1;
            }else if(nums[i] < left[i] && nums[i] < right[i]){
                map[i] = 0;
            }else{
                map[i] = -1;
                continue;
            }

            if(map[i] == -1 || map[i-1] == map[i]) continue;
            else count++;
        }
        return count;
    }
}