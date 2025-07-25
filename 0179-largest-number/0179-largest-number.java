class Solution {
    public String largestNumber(int[] nums) {
        List<String> str = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            str.add(String.valueOf(nums[i]));
        }

        Collections.sort(str, (a,b) -> (b + a).compareTo(a + b));
        if (str.get(0).equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }

        return sb.toString();
    }
}