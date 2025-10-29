class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxCapacity = Integer.MIN_VALUE;
        
        int i = 0, j = n-1;

        while(i < j){
            int currCapacity = (j - i) * Math.min(height[i], height[j]);
            maxCapacity = Math.max(maxCapacity, currCapacity);
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }

        return maxCapacity;
    }
}