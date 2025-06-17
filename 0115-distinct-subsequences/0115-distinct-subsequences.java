class Solution {
    int[][] dp;
    public int helper(String s, int i, String t, int j){
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;

        if(s.charAt(i) == t.charAt(j)){
            ans =  helper(s, i-1, t, j-1) + helper(s, i-1, t, j);
        }else{
            ans = helper(s, i-1, t, j);
        }
        dp[i][j] = ans;
        return ans;
    }
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        dp = new int[n+1][m+1];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(s, n-1, t, m-1);
    }
}