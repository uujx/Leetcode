class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int pre = pair[1];
            int ready = pair[0];
            if (matrix[pre][ready] == 0)
                indegree[ready]++;
            matrix[pre][ready] = 1;
        }
        
        Queue<Integer> S = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                S.offer(i);
        }        
        
        int count = 0;
        while (!S.isEmpty()) {
            int course = S.poll();
            count++;
            
            for (int j = 0; j < numCourses; j++) {
                if (matrix[course][j] != 0) {
                    if (--indegree[j] == 0)
                        S.offer(j);
                }
            }
        }
        
        return count == numCourses;
    }
}
