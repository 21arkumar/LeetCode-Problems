class Solution {
    public void helper(int open, int close, String str,  List<String> ans){
        if(open == 0 && close == 0){
            ans.add(str);
        }
        String op = "(";
        String cl = ")";
        if(open > 0){
            helper(open - 1, close, str + op, ans);
        }
        if(close > open){
            helper(open, close - 1, str + cl, ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        String str = "";
        List<String> res = new ArrayList<>();
        helper(n, n, str, res);
        return res;
    }
}