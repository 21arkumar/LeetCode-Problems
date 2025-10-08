class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;

        Arrays.sort(potions);

        int[] ans = new int[m];

        for(int i = 0; i < m; i++){
            int left = 0, right = n-1;
            int index = -1;
            while(left <= right){
                int mid = (left + right) / 2;
                long p = potions[mid];
                long s = spells[i];
                if(p*s >= success){
                    index = mid;
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }

            if(index != -1){
                ans[i] = n - index;
            }else{
                ans[i] = 0;
            }
        }

        return ans;
    }
}