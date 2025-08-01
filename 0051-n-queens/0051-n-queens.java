class Solution {
    //generates all possible positions of Q on the board
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
    //checks whether Q can be placed at it's position or not
    public boolean validPosition(List<String> sol, int column){
        int n = sol.size();
        int front = column, back = column;
        for(int row = n-1; row >= 0; row--){
            String s = sol.get(row);
            //left diagonal
            if(back - 1 >= 0){
                if(s.charAt(--back) == 'Q') return false;
            }
            //right diagonal
            if(front + 1 < s.length()){
                if(s.charAt(++front) == 'Q') return false;
            }
        }

        return true;
    }

    //places Q in all possible positions on board until the correct position is found
    public void backtrack(List<List<String>> ans, List<String> queen, List<String> sol, boolean[] visited){
        if(sol.size() == visited.length){
            //make sure to create deep copy, if only sol is added to ans, any changes to sol later on, also changes values inside ans b'cuz same object reference
            ans.add(new ArrayList<>(sol));  
            return;
        }
        for(int i = 0; i < queen.size(); i++){
            if(visited[i] == true) continue;

            if(validPosition(sol, i)){
                visited[i] = true;
                sol.add(queen.get(i));
                backtrack(ans, queen, sol, visited);
                visited[i] = false;
                sol.remove(sol.size() - 1); // check rest of index, even when correct index is valid
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        List<String> queen = new ArrayList<>();
        possibilities(queen, n);

        for(int i = 0; i < queen.size(); i++){
            boolean[] visited = new boolean[n];
            visited[i] = true;
            List<String> sol = new ArrayList<>();
            sol.add(queen.get(i));
            backtrack(ans, queen, sol, visited);
        }

        return ans;
    }
}