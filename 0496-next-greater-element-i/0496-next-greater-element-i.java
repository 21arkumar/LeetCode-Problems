class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st;
        int[] ans = new int[nums1.length];
        Arrays.fill(ans,-1);

        for(int i = 0; i < nums1.length; i++){
            st = new Stack<>();
            for(int j = nums2.length-1; j >= 0; j--){
                if(nums1[i] != nums2[j]){
                    st.push(nums2[j]);
                }else{
                    while(!st.empty() && st.peek() <= nums1[i]){
                        st.pop();
                    }
                    if(!st.empty()){
                        ans[i] = st.pop();
                    }
                }
            }
        }
        return ans;
    }
}