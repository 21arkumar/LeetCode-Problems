class Solution {
    public int maxArea(int[] height) {
        int dist = height.length-1;
        int i = 0;
        int j = height.length-1;

        int maxWater = Integer.MIN_VALUE;
        while(i < j){
            int currWater = Math.min(height[i], height[j]) * dist;
            maxWater = Math.max(maxWater, currWater);

            if(height[i] < height[j]){
                i++;
            }else if(height[i] > height[j]){
                j--;
            }else{
                i++;
                j--;
                dist--;
            }
            dist--;
        }

        return maxWater;
    }
}