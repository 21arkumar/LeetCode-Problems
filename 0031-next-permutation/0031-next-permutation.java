class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;

        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }

        if(pivot == -1){
            reverse(nums, 0, n-1);
        }else{
            int sRight = pivot+1;
            
            while(nums[sRight] < nums[pivot]){
                sRight++;
            }

            for(int i = sRight+1; i < n; i++){
                if(nums[i] > nums[pivot] && nums[sRight] >= nums[i]){
                    sRight = i;
                }
            }

            swap(nums, pivot, sRight);

            reverse(nums, pivot+1, n-1);
        }

    }
}