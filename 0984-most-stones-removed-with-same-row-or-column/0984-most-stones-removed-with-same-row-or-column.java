class DisjointSet {
    int[] parent;
    int[] rank;

    // Constructor
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // every node is its own parent initially
            rank[i] = 0;    // initial rank (or size if you prefer)
        }
    }

    // Find with Path Compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    // Union by Rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    // Check if two nodes are in the same set
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;

        for(int[] arr : stones){
            maxRow = Math.max(maxRow, arr[0]);
            maxCol = Math.max(maxCol, arr[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] it : stones){
            int nodeRow = it[0];
            int nodeCol = it[1] + maxRow + 1;

            ds.union(nodeRow, nodeCol);
            map.put(nodeRow, 1);
            map.put(nodeCol, 1);
        }

        int cnt = 0;
        for(int key : map.keySet()){
            if(ds.find(key) == key){ 
                cnt++;
            }
        }

        return n - cnt;
    }
}