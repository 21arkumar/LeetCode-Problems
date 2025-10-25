class Solution {
    public int totalMoney(int n) {
        int monday = 1;
        int money = 1;
        int day = 1;
        int total = 0;

        while(n-- > 0){
            if(day > 7){
                day = 1;
                monday++;
                money = monday;
            }
            
            total += money;
            money++;
            day++;
        }

        return total;
    }
}