class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int i = 0;
        boolean vis[] = new boolean[n];

        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String newStr = new String(ch);

            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
            }
            map.get(newStr).add(str);
        }

        for(Map.Entry<String, List<String>> e : map.entrySet()){
            res.add(e.getValue());
        }

        return res;
    }
}