class Solution {
    int[][] dp;
    int helper(String s1, int ind1, String s2, int ind2){
        if(ind1 < 0 || ind2 < 0) return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return 1 + helper(s1, ind1-1, s2, ind2-1);
        }else{
            dp[ind1][ind2] = Math.max(helper(s1, ind1-1, s2, ind2), helper(s1, ind1, s2, ind2-1));
            return dp[ind1][ind2];
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        dp = new int[n][m];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(text1, n-1, text2, m-1);
    }
}