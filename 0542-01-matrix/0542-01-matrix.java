class Pair{
    int row, col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j));
                }else{
                    res[i][j] = -1;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Pair pair = q.poll();

                for(int[] dir : dirs){
                    int x = pair.row + dir[0];
                    int y = pair.col + dir[1];

                    if(x < 0 || y < 0 || x >= m || y >= n || res[x][y] != -1) continue;

                    if(res[x][y] == -1){
                        if(mat[x][y] == 0){
                            res[x][y] = 0;
                        }else{
                            res[x][y] = res[pair.row][pair.col] + 1;
                        }
                        q.add(new Pair(x, y));
                    }  
                }
            }
        }

        return res;
    }
}