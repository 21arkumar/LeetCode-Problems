class Solution {
    public String largestGoodInteger(String num) {
        int res = 0;
        boolean found = false;
        for(int i = 0; i <= num.length()-3; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(num.substring(i, i+3));
            boolean flag = true;
            for(int j = 1; j < 3; j++){
                if(sb.charAt(j) != sb.charAt(j-1)){
                    flag = false;
                }
                if(j == 2 && sb.charAt(j) != sb.charAt(j-1)){
                    i += 1;
                }
            }
            if(flag){
                res = Math.max(Integer.parseInt(sb.toString()), res);
                found = true;
                i += 2;
            }
        }

        return !found ? "" : (res > 0) ? ""+res : "000";
    }
}