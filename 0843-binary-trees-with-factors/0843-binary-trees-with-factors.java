class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int ans = 0;
        int MOD = 1000000007;
        Map<Integer, Long> dp = new HashMap<>();
        for(int num : arr){
            dp.put(num, 1L);
        }

        for (int i = 0; i < n; i++) {
            int root = arr[i];
            for (int j = 0; j < i; j++) {
                if (root % arr[j] == 0) {
                    int right = root / arr[j];
                    if (dp.containsKey(right)) {
                        long ways = (dp.get(arr[j]) * dp.get(right)) % MOD;
                        dp.put(root, (dp.get(root) + ways) % MOD);
                    }
                }
            }
            ans = (int) (ans + dp.get(root)) % MOD;
        }

        return ans;
    }
}