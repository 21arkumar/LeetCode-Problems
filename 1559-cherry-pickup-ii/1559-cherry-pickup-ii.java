class Solution {
    int[][][] dp;
    int helper(int i, int j1, int j2, int r, int c, int[][] grid){
        if(j1 < 0 || j1 >= c || j2 < 0 || j2 >= c){
            return -1;
        }

        if(i == r-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        int max = -1;
        for(int k1 = -1; k1 <= 1; k1++){
            for(int k2 = -1; k2 <= 1; k2++){
                int value = 0;
                if(j1 == j2){
                    value = grid[i][j1] + helper(i+1, j1+k1, j2+k2, r, c, grid);
                }else{
                    value = grid[i][j1] + grid[i][j2] + helper(i+1, j1+k1, j2+k2, r, c, grid);
                }
                max = Math.max(max, value);
                dp[i][j1][j2] = max;
            }
        }
        return max;
    }
    public int cherryPickup(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        dp = new int[r][c][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, 0, c-1, r, c, grid);
    }
}