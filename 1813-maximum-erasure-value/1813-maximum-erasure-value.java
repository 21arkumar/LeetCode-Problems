class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0, j = 0;

        while(j < nums.length){
            int num = nums[j];
            if(!mp.containsKey(num)){
                mp.put(num, 1);
                sum += num;
                res = Math.max(sum, res);
                j++;
            }else{
                while(mp.containsKey(nums[j])){
                    mp.remove(nums[i]);
                    sum -= nums[i];
                    i++;
                }
            }
        }
        return res;
    }
}