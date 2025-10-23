class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder str = new StringBuilder(s);
        //StringBuilder ans = new StringBuilder();
        while(str.length() > 2){
            StringBuilder temp = new StringBuilder();
            for(int i = 1; i < str.length(); i++){
                String s1 = String.valueOf(str.charAt(i-1));
                String s2 = String.valueOf(str.charAt(i));
                temp.append((Integer.parseInt(s1) + Integer.parseInt(s2)) % 10);
            }
            str.setLength(0);
            str.append(temp);
        }

        if(str.charAt(0) == str.charAt(1)){
            return true;
        }

        return false;
    }
}