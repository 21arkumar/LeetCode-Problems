class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        
        int r = 0, c = 0;
        int dir = 1; // 1 = up-right, -1 = down-left

        for (int i = 0; i < m * n; i++) {
            res[i] = mat[r][c];

            // moving up-right
            if (dir == 1) {
                if (c == n - 1) { // hit right wall
                    r++;
                    dir = -1;
                } else if (r == 0) { // hit top wall
                    c++;
                    dir = -1;
                } else {
                    r--;
                    c++;
                }
            }
            // moving down-left
            else {
                if (r == m - 1) { // hit bottom wall
                    c++;
                    dir = 1;
                } else if (c == 0) { // hit left wall
                    r++;
                    dir = 1;
                } else {
                    r++;
                    c--;
                }
            }
        }

        return res;
    }
}
