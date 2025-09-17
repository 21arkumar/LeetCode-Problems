class Solution {
    Boolean[][] dp;
    boolean helper(int[] stones, int index, int k){
        if(index == stones.length - 1) return true;

        if(dp[index][k] != null){
            return dp[index][k];
        }

        int currIndex = index;
        int currSum = stones[index] + k;
        for(int i = index; i < stones.length; i++){
            if(stones[i] > currSum){
                break;
            }else if(currSum == stones[i]){
                currIndex = i;
                break;
            }
        }

        if(currIndex == index) return false;
        
        return dp[index][k] = helper(stones, currIndex, k-1) || helper(stones, currIndex, k) || helper(stones, currIndex, k + 1);
    }


    public boolean canCross(int[] stones) {
        dp = new Boolean[stones.length][stones.length + 1];

        for(Boolean[] arr : dp){
            Arrays.fill(arr, null);
        }
        return helper(stones, 0, 1);    
    }
}