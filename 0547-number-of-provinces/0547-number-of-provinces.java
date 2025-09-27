class DSU{
    int[] parent;
    int[] rank; 

    DSU(int n){
        parent = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            parent[i] = i;
            rank[i] = 0;        //rank intially 0 for all nodes
            
        }
    }

    public int findParent(int u){
        if(parent[u] == u){
            return u;
        }
        
        return parent[u] = findParent(parent[u]);
    
    }

    public void unionByRank(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu != pv){
            if(rank[pu] > rank[pv]){
                parent[pv] = pu;
            }else if(rank[pu] < rank[pv]){
                parent[pu] = pv;
            }else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(isConnected[i][i] == isConnected[i][j]){
                    dsu.unionByRank(i+1, j+1);
                }
            }
        }

        Set<Integer> set = new HashSet<>();

        for(int i = 1; i <= n; i++){
            int val = dsu.findParent(i);
            System.out.println("Parent of " + i + " = " + val);
            set.add(val);
        }

        return set.size();
    }
}