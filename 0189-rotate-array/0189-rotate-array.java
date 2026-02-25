class Solution {
    public void rotate(int[] nums, int k) {
        int move = k % nums.length;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){
            if(move> 0){
                q.add(nums[i]);
                move--;
            }else{
                q.add(nums[i]);
                nums[i] = q.poll();
            }
        }
        int i = 0;
        while(!q.isEmpty()){
            nums[i] = q.poll();
            i++;
        }
    }
}