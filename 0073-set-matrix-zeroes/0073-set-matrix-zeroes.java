class Solution {
    public void convert(int[][] matrix, int x, int y){
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < n; i++){
            matrix[x][i] = -1;
        } 

        for(int i = 0; i < m; i++){
            matrix[i][y] = -1;
        } 
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] temp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    convert(temp, i, j);
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(temp[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}