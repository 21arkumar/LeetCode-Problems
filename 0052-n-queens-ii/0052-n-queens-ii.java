class Solution {
    int count = 0;
    //generates all possbilities of Q placement
    public void possibilities(List<String> queens, int n){
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(j == i){
                    sb.append("Q");
                    continue;
                }
                sb.append(".");
            }
            queens.add(sb.toString());
        }
    }
    //check if queen placement is valid or not
    public boolean validQueen(List<String> sol, int column){
        int n = sol.size();
        int back = column, front = column;
        for(int row = n - 1; row >= 0; row--){
            String str = sol.get(row);
            //check left diagonal
            if(back - 1 >= 0){
                if(str.charAt(--back) == 'Q') return false;
            }
            //check right diagonal
            if(front + 1 < str.length()){
                if(str.charAt(++front) == 'Q') return false;
            }
        }
        return true;
    }
    //backtracking algo
    public void backtrack(List<String> queen, List<String> sol, boolean[] visited){
        if(sol.size() == queen.size()){
            count++;
            return;
        }

        for(int i = 0; i < queen.size(); i++){
            if(visited[i]) continue;

            if(validQueen(sol, i)){
                sol.add(queen.get(i));
                visited[i] = true;
                backtrack(queen, sol, visited);
                sol.remove(sol.size() - 1);
                visited[i] = false;
            }
        }
    }
    //entry function
    public int totalNQueens(int n) {
        List<String> queens = new ArrayList<>();
        possibilities(queens, n);
        
        for(int i = 0; i < n; i++){
            boolean[] visited = new boolean[n];
            List<String> sol = new ArrayList<>();
            sol.add(queens.get(i));
            visited[i] = true;
            
            backtrack(queens, sol, visited);
            sol.remove(sol.size() - 1);
            visited[i] = false;
        }
        return count;
    }
}