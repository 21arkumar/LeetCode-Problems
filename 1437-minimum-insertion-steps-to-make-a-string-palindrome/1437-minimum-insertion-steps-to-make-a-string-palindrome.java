class Solution {
    public int minInsertions(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        String reversedString = stringBuilder.reverse().toString();

        int n = s.length(), m = reversedString.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == reversedString.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return n - dp[n][m];
    }
}