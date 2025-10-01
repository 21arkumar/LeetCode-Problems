class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        while(numBottles >= numExchange){
            int rem = numBottles % numExchange;
            int convert = (numBottles - rem) / numExchange;
            count += convert;
            numBottles = convert + rem;
        }

        return count;
    }
}