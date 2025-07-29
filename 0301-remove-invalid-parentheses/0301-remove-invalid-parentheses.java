class Solution {
    //checks for the strings validity
    public boolean validParentheses(String str){
        int balance = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') balance++;
            else if (ch == ')') {
                if (balance == 0) return false;
                balance--;
            }
        }
        return balance == 0;
    }

    //removes brackets
    public void removeParentheses(String str, int removeCount, Set<String> res, Set<String> visited){
        if (visited.contains(str)) return;
        
        visited.add(str);
        
        if(removeCount == 0){
            if(validParentheses(str)){
                res.add(str);
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            //skips duplicate characters
            if (i > 0 && str.charAt(i) == str.charAt(i - 1)) continue;
            //only checks brackets
            if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;

            StringBuilder sb = new StringBuilder(str);
            sb.deleteCharAt(i);
            removeParentheses(sb.toString(), removeCount - 1, res, visited);
        }
    }

    //counts the number of misplaced open or closed brackets
    public int parenCount(String s){
        int open = 0;
        int close = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') open++;
            else if(ch == ')' && open > 0) open--;
            else if(ch == ')') close++;
        }

        return open+close;
    }
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new LinkedHashSet<>();
        Set<String> visited = new HashSet<>();

        //1. count the number of misplaced characters
        int removeCount = parenCount(s);

        //2. removes brackets and checks for the validity of the string
        removeParentheses(s, removeCount, res, visited);

        return new ArrayList<>(res);
    }
}