class Solution {
    public int copy(int n, int word, int paste, int prevWord, int prevPaste){
        if(word == n) return 1;

        if((word == prevWord && paste == prevPaste) || word > n) return 1001;


        int cpy = copy(n, word, word, word, paste);
        int pst = copy(n, word+paste, paste, word, paste);

        return Math.min(cpy, pst) + 1;

    }
    public int minSteps(int n) {
        int word = 1;
        int paste = 0;

        if(word == n) return 0;
        return copy(n, word, word, word, paste);
    }
}