class Solution {
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
    public boolean validPosition(List<String> sol, int column){
        int n = sol.size();
        int front = column, back = column;
        for(int row = n-1; row >= 0; row--){
            String s = sol.get(row);
            if(back - 1 >= 0){
                if(s.charAt(--back) == 'Q') return false;
            }
            if(front + 1 < s.length()){
                if(s.charAt(++front) == 'Q') return false;
            }
        }

        return true;
    }

    public boolean backtrack(List<List<String>> ans, List<String> queen, List<String> sol, boolean[] visited){
        if(sol.size() == visited.length){
            ans.add(new ArrayList<>(sol));
            return true;
        }
        for(int i = 0; i < queen.size(); i++){
            if(visited[i] == true) continue;

            if(validPosition(sol, i)){
                visited[i] = true;
                sol.add(queen.get(i));
                if(!backtrack(ans, queen, sol, visited)){
                    visited[i] = false;
                    sol.remove(sol.size() - 1);
                }else{
                    visited[i] = false;
                    sol.remove(sol.size() - 1);
                }
            }
        }
        return false;
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
            if(!backtrack(ans, queen, sol, visited)){
                continue;
            }
        }

        return ans;
    }
}