class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Normalize and count remainders
        for (int num : nums) {
            int mod = ((num % value) + value) % value; // ensures positive remainder
            freq.put(mod, freq.getOrDefault(mod, 0) + 1);
        }

        int ans = 0;
        while (true) {
            int mod = ans % value;
            if (freq.getOrDefault(mod, 0) == 0) {
                return ans; // smallest missing
            }
            freq.put(mod, freq.get(mod) - 1);
            ans++;
        }
    }
}
