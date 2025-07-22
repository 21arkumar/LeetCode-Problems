class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder str = new StringBuilder();

        int len = s.length();
        
        //top row
        int i = 0;
        while(i < len){
            str.append(s.charAt(i));
            i += ((2*numRows) - 2);
        }

        //middle Row
        for(i = 1; i < numRows-1; i++){
            int j = i;
            while(j < len){
                str.append(s.charAt(j));
                j += ((2*numRows) - 2) - (2*i);
                if(j < len){
                    str.append(s.charAt(j));
                    j += i*2;
                }
            }
        }


        //bottom row
        i = numRows-1;
        while(i < len){
            str.append(s.charAt(i));
            i += ((2*numRows) - 2);
        }

        return str.toString();
    }
}