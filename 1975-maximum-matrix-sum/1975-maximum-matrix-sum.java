class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long minVal = Integer.MAX_VALUE;
        long cnt = 0, sum = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sum += Math.abs(matrix[i][j]);

                if(matrix[i][j] < 0){
                    cnt++;
                }

                if(Math.abs(matrix[i][j]) < minVal){
                    minVal = Math.abs(matrix[i][j]);
                }
            }
        }

        if(cnt % 2 == 0 || minVal == 0){
            return sum;
        }else{
            return sum - (minVal*2);
        }
    }
}