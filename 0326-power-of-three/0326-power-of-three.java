class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        double val = (int) n;
        while(val > 0){
            val = val/3;
            if(val == 1.00) return true;
        }

        return false;
    }
}