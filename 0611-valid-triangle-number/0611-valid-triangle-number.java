class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for(int i = n-1; i >= 2; i--){
            int a = nums[i];
            int j = 0, k = i-1;

            while(j < k){
                int b = nums[j];
                int c = nums[k];
                if(b + c > a){
                    count += k - j;
                    k--;
                }else{
                    j++;
                }
            }

        }

        return count;
    }
}