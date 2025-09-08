class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = n;
        int b = 0;
        for(int i = 1; i < n; i++){
            if(check(""+a, ""+b)){
                return new int[]{a, b};
            }

            a = n-i;
            b = i;
        }
        return new int[]{a, b};
    }

    boolean check(String a, String b){
        for(char ch : a.toCharArray()){
            if(ch == '0') return false;
        }
        for(char ch : b.toCharArray()){
            if(ch == '0') return false;
        }
        return true;
    }
}