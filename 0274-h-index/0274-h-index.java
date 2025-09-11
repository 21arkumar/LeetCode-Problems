class Solution {
    public int hIndex(int[] citations) {
        Integer[] cit = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++){
            cit[i] = citations[i];
        }
        Arrays.sort(cit, Collections.reverseOrder());

        int hIndex = 0;

        for(int i = 1; i <= citations.length; i++){
            if(cit[i-1] >= i){
                hIndex = i;
            }
        }

        return hIndex;
    }
}