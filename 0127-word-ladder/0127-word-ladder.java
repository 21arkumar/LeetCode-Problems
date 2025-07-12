class Solution {
    boolean helper(String word, String curr){
        int cnt = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != curr.charAt(i)){
                cnt++;
            }
        }

        return (cnt == 1);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        int chain = 0;
        boolean[] vis = new boolean[wordList.size()];
        Queue<String> q = new LinkedList<>();

        for(int i = 0; i < wordList.size(); i++){
            String curr = wordList.get(i);
            boolean val = helper(beginWord, curr);
            
            if(val && curr.equals(endWord)) return 2;

            if(val){
                vis[i] = true;
                q.add(curr);
            }
        }
        if(!q.isEmpty()) chain += 2;
        
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                String currWord = q.poll();

                for(int j = 0; j < wordList.size(); j++){
                    if(vis[j]) continue;

                    String curr = wordList.get(j);
                    boolean val = helper(currWord, curr);

                    if(val && curr.equals(endWord)) return chain+1;
                    if(val){
                        vis[j] = true;
                        q.add(curr);
                    }
                }
            }
            chain++;
        }
        if(!vis[wordList.size()-1]) return 0;

        return chain;
    }
}