class Solution {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> y_arr = new ArrayList<>();
        int[] ans = new int[2*n];

        for(int i = n; i < nums.length; i++){
            y_arr.add(nums[i]);
        }
        int j = 0;
        for(int i = 0; i < 2*n; i+=2){
            ans[i] = nums[j];
            ans[i+1] = y_arr.get(j);
            j++;
        }

        return ans;
    }
}