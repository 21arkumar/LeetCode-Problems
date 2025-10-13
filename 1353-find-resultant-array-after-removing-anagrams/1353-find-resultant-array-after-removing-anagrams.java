class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]); 
        
        for (int i = 1; i < words.length; i++) {
            char[] curr = words[i].toCharArray();
            char[] prev = words[i - 1].toCharArray();
            
            Arrays.sort(curr);
            Arrays.sort(prev);
            
            if (!Arrays.equals(curr, prev)) {
                ans.add(words[i]);
            }
        }

        return ans;
    }
}