class Solution {
    public int maximum69Number (int num) {
        StringBuilder str = new StringBuilder((""+num));
        
        int newNum = num;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '9'){
                str.replace(i, i+1, "6");
                newNum = Math.max(Integer.parseInt(str.toString()), newNum);
                str.replace(i, i+1, "9");
            }else{
                str.replace(i, i+1, "9");
                newNum = Math.max(Integer.parseInt(str.toString()), newNum);
                str.replace(i, i+1, "6");
            }
        }
        return newNum;
    }
}