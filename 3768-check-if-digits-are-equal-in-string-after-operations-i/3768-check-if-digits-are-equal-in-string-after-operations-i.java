class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder str = new StringBuilder(s);

        while(str.length() > 2){
            StringBuilder temp = new StringBuilder();
            for(int i = 1; i < str.length(); i++){
                temp.append(((str.charAt(i-1)-'0')+(str.charAt(i)-'0')) % 10);
            }
            str.setLength(0);
            str.append(temp);
        }

        return str.charAt(0)== str.charAt(1);
    }
}