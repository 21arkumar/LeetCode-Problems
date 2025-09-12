class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        int[][] dirs = {{0,1}, {1,-1}, {1,0}, {1,1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
        int[][] copy = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                copy[i][j] = board[i][j];
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int liveCount = 0;
                for(int[] dir : dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    
                    if((x >= 0 && x < m) && (y >= 0 && y < n) && copy[x][y] == 1) liveCount++;
                }

                if(copy[i][j] == 1 && (liveCount < 2 || liveCount > 3)) board[i][j] = 0;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int liveCount = 0;
                for(int[] dir : dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    
                    if((x >= 0 && x < m) && (y >= 0 && y < n) && copy[x][y] == 1) liveCount++;
                }

                if(copy[i][j] == 0 && liveCount == 3) board[i][j] = 1;
            }
        }

    }
}