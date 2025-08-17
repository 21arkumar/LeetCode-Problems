class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) return 1.0; // always win
        
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double windowSum = 1.0, result = 0.0;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;
            
            if (i < k) {
                windowSum += dp[i];   // still drawing cards
            } else {
                result += dp[i];      // game stopped
            }
            
            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }
        
        return result;
    }
}
