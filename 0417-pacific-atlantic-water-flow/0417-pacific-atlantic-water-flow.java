class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n;
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }

        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;

        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            dfs(0, j, canReachPacific, Integer.MIN_VALUE);
            dfs(m - 1, j, canReachAtlantic, Integer.MIN_VALUE);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachPacific, Integer.MIN_VALUE);
            dfs(i, n - 1, canReachAtlantic, Integer.MIN_VALUE);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int prevHeight) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        for (int[] dir : dirs) {
            dfs(r + dir[0], c + dir[1], visited, heights[r][c]);
        }
    }
}