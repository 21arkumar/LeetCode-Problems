class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] results = new int[n];

        for(int i = 0; i < n; i++){
            results[i] = nums[(((i + nums[i]) % n) + n) % n];
        }

        return results;
    }
}