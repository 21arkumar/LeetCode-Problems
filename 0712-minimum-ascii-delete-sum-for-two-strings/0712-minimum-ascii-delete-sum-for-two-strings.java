class Solution {
    int[][] dp;

    public int remainder(String str, int indx){
        int sum = 0;
        while(indx < str.length()){
            sum += str.charAt(indx);
            indx++;
        }
        return sum;
    }

    public int helper(String s1, String s2, int i, int j){
        if(i >= s1.length() || j >= s2.length()){
            if(i >= s1.length()){
                return remainder(s2, j);
            }else if(j >= s2.length()){
                return remainder(s1, i);
            }else{
                return 0;
            }
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = (0 + helper(s1, s2, i+1, j+1));
        }else{
            return dp[i][j] = Math.min(((0 + s1.charAt(i)) +  helper(s1, s2, i+1, j)), ((0 + s2.charAt(j)) +  helper(s1, s2, i, j+1)));
        }

    }
    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];
        for(int[] curr : dp){
            Arrays.fill(curr, -1);
        }
        return helper(s1, s2, 0, 0);
    }
}