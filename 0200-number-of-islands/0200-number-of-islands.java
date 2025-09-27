class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void bfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || grid[i][j] == '2' ){
            return;
        }
        grid[i][j] = '2';
        for(int[] d : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            bfs(grid, ni, nj);
        }
    }   
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}