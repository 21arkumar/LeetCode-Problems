class Solution {
    int count = 0;
    int helper(String s, int i, int j){
        int currCount = 0;
        while(i >= 0 && j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                currCount++;
            }else{
                break;
            }
            i--;
            j++;
        }

        return currCount;
    }

    public int countSubstrings(String s) {
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            count += helper(s, i, i) + helper(s, i, i + 1);
        }

        return count;
    }
}