class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        for(int i = n-1; i >= 0; i--){
            st.push(nums[i]);
        }

        int[] res = new int[n];
        Arrays.fill(res,-1);

        for(int i = n-1; i >= 0; i--){
            while(!st.empty() && st.peek() <= nums[i]){
                st.pop();
            }
            if(!st.empty()){
                res[i] = st.peek();
            }
            st.push(nums[i]);
        }

        return res;
    }
}