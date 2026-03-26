class Solution {
    void convert(int[][] mat, int x, int y){
        for(int i = 0; i < mat[0].length ;i++){
            mat[x][i] = 0;
        }
        for(int i = 0; i < mat.length ;i++){
            mat[i][y] = 0;
        }
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] zero = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0) zero[i][j] = true;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0 && zero[i][j]){
                    convert(matrix, i, j);
                }
            }
        }
    }
}