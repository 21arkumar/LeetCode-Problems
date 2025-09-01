class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;

    TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26];
    }
}

class Trie {
    
    TrieNode getNode(){
        TrieNode newNode = new TrieNode();
        newNode.isEndOfWord = false;

        return newNode;
    }
    
    TrieNode root;
    
    public Trie() {
        root = getNode();
    }
    
    public void insert(String word) {
        TrieNode crawler = root;
        for(char ch : word.toCharArray()){
            int indx = ch - 'a';
            if(crawler.children[indx] == null){
                crawler.children[indx] = getNode();
            }
            crawler = crawler.children[indx];
        }
        crawler.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode crawler = root;
        for(char ch : word.toCharArray()){
            int indx = ch - 'a';
            if(crawler.children[indx] == null){
                return false;
            }
            crawler = crawler.children[indx];
        }
        if(crawler != null && crawler.isEndOfWord == true){
            return true;
        }

        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        int i = 0;
        for(char ch : prefix.toCharArray()){
            i++;
            int indx = ch - 'a';
            if(crawler.children[indx] == null){
                return false;
            }
            crawler = crawler.children[indx];
        }
        if(i == prefix.length()){
            return true;
        }

        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */