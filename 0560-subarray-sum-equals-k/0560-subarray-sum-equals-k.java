class Solution {
    public int subarraySum(int[] nums, int k) {
        int i = 0, n = nums.length;
        int sum = 0, res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        while(i < n){
            sum = sum + nums[i];
            int diff_sum = sum - k;

            if(map.containsKey(diff_sum)){
                res += map.get(diff_sum);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1); 
            i++;
        }
        return res;
    }
}