class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(int val : map.keySet()){
            if(map.get(val) == n){
                return val;
            }
        }
        return -1;
    }
}