class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); 

        for (int i = 0; i < n; i++) {
            if (color[i] != -1) continue; 

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 0;

            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int neighbor : graph[curr]) {
                    if (color[neighbor] == -1) {
                        color[neighbor] = 1 - color[curr];
                        q.add(neighbor);
                    } else if (color[neighbor] == color[curr]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
