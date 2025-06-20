class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int currProductLeft = 1;
        int currProductRight = 1;
        for(int i = 0; i < nums.length; i++){
            currProductLeft *= nums[i];
            currProductRight *= nums[nums.length-1-i];

            maxProduct = Math.max(maxProduct, Math.max(currProductLeft, currProductRight));

            if(currProductLeft == 0) currProductLeft = 1;
            if(currProductRight == 0) currProductRight = 1;
        }
        return maxProduct;
    }
}