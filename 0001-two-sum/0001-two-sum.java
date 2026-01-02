class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for(int i = 1; i<nums.length; i++){
            int val = target-nums[i];
            if(map.containsKey(val)){
                return new int[]{map.get(val), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}