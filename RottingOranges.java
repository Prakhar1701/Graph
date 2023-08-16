import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    // https://leetcode.com/problems/rotting-oranges/description/

    class Solution {

        public boolean isValid(int[][] grid, int i, int j) {

            int m = grid.length;
            int n = grid[0].length;

            if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == 1)
                return true;

            return false;
        }

        class Pair {
            int row, col;

            Pair(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        public int orangesRotting(int[][] grid) {

            int time = 0;

            int m = grid.length;
            int n = grid[0].length;

            boolean fresh = false;

            Queue<Pair> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2)
                        queue.add(new Pair(i, j));
                    else if (grid[i][j] == 1)
                        fresh = true;
                }
            }

            if (!fresh)
                return 0;

            while (!queue.isEmpty()) {

                int s = queue.size();

                boolean t = false;

                while (s-- > 0) {

                    Pair r = queue.poll();

                    int i = r.row;
                    int j = r.col;

                    int[] x = { 1, -1, 0, 0 };
                    int[] y = { 0, 0, 1, -1 };

                    for (int k = 0; k < 4; k++) {

                        int ni = x[k] + i;
                        int nj = y[k] + j;

                        if (isValid(grid, ni, nj)) {
                            grid[ni][nj] = 2;
                            queue.add(new Pair(ni, nj));
                            t = true;
                        }

                    }

                }

                if (t)
                    time++;
            }

            fresh = false;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1)
                        fresh = true;
                }
            }

            if (fresh)
                return -1;

            return time;
        }
    }

}
