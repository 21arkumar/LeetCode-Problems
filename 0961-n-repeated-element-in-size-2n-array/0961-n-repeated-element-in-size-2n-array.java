class Solution {
    public int repeatedNTimes(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                return nums[i];
            }
            list.add(nums[i]);
        }
        return -1;
    }
}