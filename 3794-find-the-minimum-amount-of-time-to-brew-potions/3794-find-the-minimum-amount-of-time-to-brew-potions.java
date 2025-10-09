class Solution {
    public long minTime(int[] skill, int[] mana) {
        int m = mana.length, n = skill.length;
        long[][] ans = new long[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i != 0){
                    if(j != 0){
                        ans[i][j] = Math.max(ans[i-1][j], ans[i][j-1]) + mana[i] * skill[j];
                    }else{
                        ans[i][j] = Math.max(ans[i-1][j], 0) + mana[i] * skill[j];
                    }
                }else{
                    if(j == 0){
                        ans[i][j] = 0 + 0 + mana[i] * skill[j];
                    }else{
                        ans[i][j] = ans[i][j-1] + 0 + mana[i] * skill[j];
                    }
                }
            }

            if(i == 0){
                continue;
            }

            for(int k = n-2; k >= 0; k--){
                ans[i][k] = ans[i][k+1] -  mana[i] * skill[k+1];
            }
        }

        return ans[m-1][n-1];
    }
}