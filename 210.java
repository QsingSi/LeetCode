class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        int[][] adj = new int[numCourses][numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]][prerequisites[i][0]] = 1;
            degree[prerequisites[i][0]]++;
        }
        for (int i = 0; i < numCourses; i++)
            if (degree[i] == 0)
                q.add(i);
        int index = 0;
        int[] path = new int[numCourses];
        while (!q.isEmpty()) {
            int top = q.remove();
            path[index++] = top;
            for (int i = 0; i < numCourses; i++) {
                if (adj[top][i] == 1 && --degree[i] == 0)
                    q.add(i);
            }
        }
        for (int i = 0; i < numCourses; i++)
            if (degree[i] > 0)
                return new int[0];
        return path;
    }
}