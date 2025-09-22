class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int i = 0, j = 0;
        int maxLen = 1;
        Set<Character> freq = new HashSet<>();
        while(j < s.length()){
            char ch = s.charAt(j);
            if(!freq.contains(ch)){
                freq.add(ch);
                maxLen = Math.max(maxLen, freq.size());
            }else{
                while(freq.contains(ch)){
                    freq.remove(s.charAt(i));
                    i++;
                }
                freq.add(s.charAt(j));
            }
            j++;
        }

        return maxLen;
    }
}