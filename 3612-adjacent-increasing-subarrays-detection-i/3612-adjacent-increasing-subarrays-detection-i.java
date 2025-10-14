class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        boolean ans = false;

        for(int i = 0; i < n - (2*k) + 1; i++){
            boolean flag1 = false, flag2 = false;

            for(int j = i+1; j < i+k; j++){
                if(nums.get(j-1) >= nums.get(j)){
                    flag1 = true;
                }
            }
            System.out.println();

            for(int j = i+k+1; j < 2*k + i; j++){
                if(nums.get(j-1) >= nums.get(j)){
                    flag2 = true;
                }
            }
            System.out.println();
            if(flag1 == false  && flag2 == false){
                ans = true;
                break;
            }
        }
        
        return ans;
    }
}