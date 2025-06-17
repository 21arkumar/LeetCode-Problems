class Solution {
    public int helper(String word1, int i, String word2, int j){
        if(i >= word1.length() && j >= word2.length()) return 0;
        if(i == word1.length()){
            return word2.length() - j;
        }
        if(j == word2.length()){
            return word1.length() - i;
        }
        int res = Integer.MAX_VALUE;

        if(word1.charAt(i) == word2.charAt(j)){
            return helper(word1, i+1, word2, j+1);
        }else{
            res = Math.min(res, 1 + helper(word1, i, word2, j + 1)); //insert
            res = Math.min(res, 1 + helper(word1, i + 1, word2, j)); //delete
            res = Math.min(res, 1 + helper(word1, i + 1, word2, j + 1)); //replace
        }
        return res;
    }

    public int minDistance(String word1, String word2) {
        return helper(word1, 0, word2, 0);
    }
}