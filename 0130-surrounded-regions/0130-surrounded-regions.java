class Solution {
    int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    //func never called on cells marked 'O' that aren't connected border
    public void dfs(char[][] board, int i, int j){ 
        if(i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1 || board[i][j] != 'O'){
            return;
        }

        board[i][j] = 'T'; //make cells connected with border cell as 'T'

        for(int[] dir : dirs){
            dfs(board, i + dir[0], j + dir[1]);
        }
    }
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        if(m == 0 || n == 0) return;

        //only check the border cells for 'O'
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][n-1] == 'O') dfs(board, i, n-1);
        }

        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O') dfs(board, 0, j);
            if(board[m-1][j] == 'O') dfs(board, m-1, j);
        }

        //make 'T' back to 'O' and 'O' to 'X'
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
}