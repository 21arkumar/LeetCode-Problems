class Solution {
    public int maximum69Number (int num) {
        int res = num;
        StringBuilder str = new StringBuilder("" + num);

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '6'){
                str.replace(i, i+1, "9");
                res = Math.max(Integer.parseInt(str.toString()), res);
                break;
            }
        }

        return res;
    }
}