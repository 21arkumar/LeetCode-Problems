class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 0;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                nums[pos] = nums[i];
                set.add(nums[i]);
                pos++;
            }
        }

        return pos;
    }
}