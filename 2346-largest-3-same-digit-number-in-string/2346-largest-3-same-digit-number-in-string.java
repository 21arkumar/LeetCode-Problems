class Solution {
    public String largestGoodInteger(String num) {
        String res = "";
        for(int i = 0; i <= num.length()-3; i++){
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)){
                String temp = num.substring(i, i+3);
                if(temp.compareTo(res) > 0){
                    res = temp;
                }
            }

        }

        return res.length() == 0 ? "" : res;
    }
}