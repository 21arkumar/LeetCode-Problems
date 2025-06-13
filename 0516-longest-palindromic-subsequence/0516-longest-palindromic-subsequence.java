class Solution {
    int[][] dp;
    public int helper(String s, int i, int j){
        if(i > j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            if(i != j){
                return 2 + helper(s, i+1, j-1);
            }else{
                return 1 + helper(s, i+1, j-1);
            }
        }
        else{
            dp[i][j] = Math.max(helper(s, i+1, j), helper(s, i, j-1));
            return dp[i][j];
        }
    }
    public int longestPalindromeSubseq(String s) {
        int i = 0, j = s.length()-1;
        dp = new int[s.length()+1][s.length()+1];

        for(int k = 0; k <= s.length(); k++){
            Arrays.fill(dp[k], -1);
        }
        return helper(s, i, j);
    }
}