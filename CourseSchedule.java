import java.util.ArrayList;

public class CourseSchedule {

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            ArrayList<Integer>[] graph = new ArrayList[numCourses];

            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < prerequisites.length; i++) {

                graph[prerequisites[i][0]].add(prerequisites[i][1]);
            }

            boolean[] vis = new boolean[numCourses];
            boolean[] stack = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {

                if (!vis[i]) {
                    if (hasCycle(graph, vis, stack, i))
                        return true;
                }

            }

            return false;

        }

        public boolean hasCycle(ArrayList<Integer>[] graph, boolean[] vis, boolean[] stack, int curr) {

            vis[curr] = true;
            stack[curr] = true;

            ArrayList<Integer> neg = graph[curr];

            for (int i = 0; i < neg.size(); i++) {

                int x = neg.get(i);

                if (stack[x])
                    return true;

                else if (!vis[x])
                    if (hasCycle(graph, vis, stack, x))
                        return true;
            }

            stack[curr] = false;
            return false;
        }
    }
}
