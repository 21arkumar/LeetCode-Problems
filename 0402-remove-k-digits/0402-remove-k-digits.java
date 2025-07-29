class Solution {
    public String stringGen(Stack<String> st){
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString().replaceFirst("^0+", "");
    }
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        
        Stack<String> st = new Stack<>();
        String[] str = num.split("");
        
        for(String ch : str){
            while(!st.isEmpty() && k > 0 && Integer.parseInt(st.peek()) > Integer.parseInt(ch)){
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while(k-- > 0 && !st.isEmpty()) {
            st.pop();
        }

        String ans = stringGen(st);
        return ans.length() == 0 ? "0" : ans;


    }
}