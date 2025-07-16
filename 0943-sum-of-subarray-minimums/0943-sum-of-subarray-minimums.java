class Solution {
    long mod = (long) 1e9+7;

    int prevSmallIndx(int[] arr, int indx){
        int j = indx - 1;
        while(j >= 0 && arr[j] >= arr[indx]){
            j--;
        }
        return j;
    }
    int nextSmallIndx(int[] arr, int indx){
        int j = indx + 1;
        while(j < arr.length && arr[j] > arr[indx]){
            j++;
        }
        return j;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int ans = 0;

        for(int i = 0; i < n; i++){
            int j = prevSmallIndx(arr, i);
            int k = nextSmallIndx(arr, i);
            long left = i - j;
            long right = k - i;

            long val = arr[i];
            long temp = (val % mod) * (left % mod);
            temp = ((temp % mod) * (right % mod)) % mod;
            ans = (int) ((ans + temp) % mod);
        }
        return ans;
    }
}