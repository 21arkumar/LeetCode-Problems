class Solution {
    public void convert(int[][] matrix, int x, int y){
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < n; i++){
            matrix[x][i] = 0;
        } 

        for(int i = 0; i < m; i++){
            matrix[i][y] = 0;
        } 
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] temp = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    temp[i][j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(temp[i][j]){
                    convert(matrix, i, j);
                }
            }
        }
    }
}