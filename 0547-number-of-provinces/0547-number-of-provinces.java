class Solution {
    public void dfs(int[][] isConnected, boolean[] vis, int node){
        vis[node] = true;
        for(int i = 0; i < isConnected[node].length; i++){
            if(vis[i] == true) continue;
            if(isConnected[node][i] == 1 && vis[i] != true){
                dfs(isConnected, vis, i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int province = 0;
        boolean[] vis = new boolean[isConnected.length];
        for(int i = 0; i < isConnected.length; i++){
            if(vis[i] == true) continue;
            
            province++;
            dfs(isConnected, vis, i);
        }
        return province;
    }
}