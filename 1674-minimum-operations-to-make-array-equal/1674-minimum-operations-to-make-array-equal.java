class Solution {
    public int minOperations(int n) {
        int ans = 0;
        int counter = 0;
        for(int i = 1; i < n; i++){
            if(i % 2 != 0){
                ++counter;
            }
            ans += counter;
        }
        return ans;
    }
}