class Solution {
    public int strStr(String haystack, String needle) {
        int size = needle.length();

        for(int i = 0; i <= haystack.length() - size; i++){
            if(needle.equals(haystack.substring(i, i+size))){
                return i;
            }
        }
        return -1;
    }
}