class Solution {
    public int sum(int num1, int num2) {
        int sum = 0;

        if(num1 < 0){
            for(int i = num1; i < 0; i++){
                sum -= 1;
            }
        }else{
            for(int i = 0; i < num1; i++){
                sum += 1;
            }
        }

        if(num2 < 0){
            for(int i = num2; i < 0; i++){
                sum -= 1;
            }
        }else{
            for(int i = 0; i < num2; i++){
                sum += 1;
            }
        }

        boolean flag = false;

        if(num1 + num2 == sum){
            flag = true;
        }

        if(flag) return num1 + num2;
        else return sum;
    }
}