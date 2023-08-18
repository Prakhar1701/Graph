import java.util.LinkedList;
import java.util.Queue;

public class Steps_by_Knight {

    class Solution {

        class Pair {
            int x, y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
            int ipki = KnightPos[0] - 1;
            int ipkj = KnightPos[1] - 1;
            int fpki = TargetPos[0] - 1;
            int fpkj = TargetPos[1] - 1;

            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(ipki, ipkj)); // Added initial position directly to the queue

            int[][] moves = {
                    { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 },
                    { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }
            };

            boolean[][] vis = new boolean[N][N];

            int steps = 0;

            while (!queue.isEmpty()) {
                int s = queue.size();

                for (int k = 0; k < s; k++) {
                    Pair curr = queue.poll();
                    int cx = curr.x;
                    int cy = curr.y;

                    if (cx == fpki && cy == fpkj) {
                        return steps;
                    }

                    for (int[] move : moves) {
                        int di = cx + move[0];
                        int dj = cy + move[1];

                        if (isValid(di, dj, N) && !vis[di][dj]) {
                            vis[di][dj] = true;
                            queue.add(new Pair(di, dj));
                        }
                    }
                }

                steps++;
            }

            return -1; // Target position cannot be reached
        }

        private boolean isValid(int i, int j, int N) {
            return i >= 0 && j >= 0 && i < N && j < N;
        }
    }
}
