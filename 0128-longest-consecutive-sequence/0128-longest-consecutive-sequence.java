class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Set<Integer> st = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            st.add(nums[i]);
        }

        for (int s : st) {
            pq.add(s);
        }

        int maxCnt = 0;
        int cnt = 0;
        System.out.println(pq);
        while(!pq.isEmpty()){
            int value = pq.poll();
            System.out.println("val = " + value);
            if(pq.peek() != null && value + 1 == pq.peek()){
                cnt++;
            }else{
                maxCnt = Math.max(maxCnt, cnt+1);
                cnt = 0;
            }
        }

        return maxCnt;
    }
}