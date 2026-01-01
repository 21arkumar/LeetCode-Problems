class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(digits[len - 1] < 9){
            digits[len - 1]++;
            return digits;
        }

        boolean flag = false;

        for(int i = 0; i < len; i++){
            if(digits[i] != 9){
                flag = true;
            }
        }

        if(flag){
            int i = len - 1;
            while(digits[i] == 9){
                digits[i] = 0;
                i--;
            }

            digits[i]++;
            return digits;
        }else{
            int[] newDigit = new int[len+1];
            newDigit[0] = 1;
            return newDigit;
        }
    }
}