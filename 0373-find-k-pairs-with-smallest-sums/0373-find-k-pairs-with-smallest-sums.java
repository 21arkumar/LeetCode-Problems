class Pair{
    int i, j;
    int sum;

    Pair(int[] nums1, int[] nums2, int i, int j){
        this.i = i;
        this.j = j;
        sum = nums1[i]+nums2[j];
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        //min head
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.sum, b.sum)
        );

        //taking minimum sum pair from each row by fixing 0's index
        for(int i = 0; i < Math.min(k, nums1.length); i++){
            Pair pair = new Pair(nums1, nums2, i, 0);
            pq.add(pair);
        }
        
        while(k-- > 0 && !pq.isEmpty()){
            Pair curr = pq.poll();
            ans.add(Arrays.asList(nums1[curr.i], nums2[curr.j]));

            //keeping the i fixed for curr pair and incrementing the j to take next min pair
            //next min pair is the next min sum pair for that row
            if (curr.j + 1 < nums2.length) {
                pq.add(new Pair( nums1, nums2, curr.i, curr.j + 1));
            }
        }

        return ans;
    }
}