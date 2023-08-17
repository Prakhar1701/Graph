public class Number_of_Islands {

    class Solution {

        static boolean isValid(char[][] grid, boolean[][] vis, int i, int j) {

            int m = grid.length;
            int n = grid[0].length;

            if (i >= 0 && j >= 0 && i < m && j < n && !vis[i][j] && grid[i][j] == '1')
                return true;

            return false;
        }

        public int numIslands(char[][] grid) {

            int m = grid.length;
            int n = grid[0].length;
            int islands = 0;

            boolean[][] vis = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (isValid(grid, vis, i, j)) {
                        dfs(grid, vis, i, j);
                        islands++;
                    }
                }
            }

            return islands;
        }

        public static void dfs(char[][] grid, boolean[][] vis, int i, int j) {

            vis[i][j] = true;

            for (int k = 0; k < 4; k++) {

                int[] x = { 1, -1, 0, 0 };
                int[] y = { 0, 0, 1, -1 };

                int ni = i + x[k];
                int nj = j + y[k];

                if (isValid(grid, vis, ni, nj))
                    dfs(grid, vis, ni, nj);
            }

        }
    }

}
