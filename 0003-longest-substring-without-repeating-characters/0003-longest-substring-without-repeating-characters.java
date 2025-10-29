class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j < n){
            char ch = s.charAt(j);
            if(!map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                maxLength = Math.max(maxLength, j-i+1);
                j++;
            }else{
                while(i < j && s.charAt(i) != ch){
                    System.out.println(i + " " + j);
                    char cb = s.charAt(i);
                    map.put(cb, map.get(cb)-1);
                    if(map.get(cb) == 0) map.remove(cb);
                    i++;
                }
                i++;
                j++;
            }
            
        }

        return maxLength;
    }
}