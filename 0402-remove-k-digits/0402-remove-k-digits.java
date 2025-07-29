class Solution {
    public String stringGen(Stack<Character> st){
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString().replaceFirst("^0+", "");
    }
    public String removeKdigits(String num, int k) {
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); ++i) {
            if (stack.isEmpty() || num.charAt(i) >= stack.peek() || k == 0) {
                stack.push(num.charAt(i));
            } else {
                stack.pop();
                --k;
                --i;
            }
        }

        while(k-- > 0 && !stack.isEmpty()) {
            stack.pop();
        }

        String ans = stringGen(stack);
        return ans.length() == 0 ? "0" : ans;


    }
}