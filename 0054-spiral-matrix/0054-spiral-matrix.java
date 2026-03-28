class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        int total = m*n;

        boolean[][] vis = new boolean[m][n];

        int i = 0, j = 0;

        int dir = 1;

        while(total-- > 0){
            if(dir == 1 && (j >= n || vis[i][j])){
                j -= 1;
                i += 1;
                dir = 2;
            }else if(dir == 2 && (i >= m || vis[i][j])){
                i -= 1;
                j -= 1;
                dir = 3;
            }else if(dir == 3 && (j < 0 || vis[i][j])){
                j += 1;
                i -= 1;
                dir = 4;
            }else if(dir == 4 && (i < 0 || vis[i][j])){
                i += 1;
                j += 1;
                dir = 1;
            }

            if(dir == 1){
                list.add(matrix[i][j]);
                vis[i][j] = true;
                j += 1;
            }

            if(dir == 2){
                list.add(matrix[i][j]);
                vis[i][j] = true;
                i += 1;
            }

            if(dir == 3){
                list.add(matrix[i][j]);
                vis[i][j] = true;
                j -= 1;
            }

            if(dir == 4){
                list.add(matrix[i][j]);
                vis[i][j] = true;
                i -= 1;
            }
        }

        return list;
    }
}