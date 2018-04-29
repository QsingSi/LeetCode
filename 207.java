class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[][] A = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            A[prerequisites[i][1]][prerequisites[i][0]] = 1;
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                q.add(i);
        while (!q.isEmpty()) {
            int top = q.remove();
            for (int i = 0; i < numCourses; i++)
                if (A[top][i] == 1 && --indegree[i] == 0)
                    q.add(i);
        }
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] > 0)
                return false;
        return true;
    }
}