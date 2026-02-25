class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 0;
        //Set<Integer> set = new HashSet<>();
        int[] freq = new int[201];

        for(int i = 0; i < nums.length; i++){
            int indx = nums[i]+100;
            if(freq[indx] == 0){
                nums[pos] = nums[i];
                //set.add(nums[i]);
                freq[indx]++;
                pos++;
            }
        }

        return pos;
    }
}