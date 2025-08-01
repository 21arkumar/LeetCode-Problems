class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        
        for(int i = 1; i < numRows; i++){
            Integer ptr1 = 0, ptr2 = 0;
            List<Integer> arr = new ArrayList<>();
            for(int j = 0; j < i+1; j++){
                if(j == 0){
                    ptr1 = 0;
                    ptr2 = ans.get(i-1).get(j);
                }else if(j == i){
                    ptr1 = ans.get(i-1).get(j-1);
                    ptr2 = 0;
                }else{
                    ptr1 = ans.get(i-1).get(j-1);
                    ptr2 = ans.get(i-1).get(j);
                }
                arr.add(ptr1 + ptr2);
            }
            ans.add(arr);
        }

        return ans;
    }
}