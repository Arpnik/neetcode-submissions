class Solution {
    private static boolean dfs(boolean[] visited, Map<Integer, List<Integer>> adjList, int current){
        if(visited[current])
            return false;
        
        visited[current] = true;
        boolean result = true;
        for(Integer nextCourse: adjList.get(current)){
            result = dfs(visited, adjList, nextCourse);
            if(!result)
                return result;
        }

        visited[current]=false;
        return result;        
    }
    //.        2|
    // 1-> 0-> 3
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=0)
            return true;
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int i;
        for(i=0;i<numCourses;i++){
            adjList.put(i, new ArrayList<Integer>());
        }
        int start, end;
        List<Integer> arr;
        for(int[] edge: prerequisites){
            start = edge[0];
            end = edge[1];
            arr = adjList.get(end);
            arr.add(start);
            adjList.put(end, arr);
        }

        boolean[] visited = new boolean[numCourses];
        for(i=0;i<numCourses;i++){
            if(!visited[i]){
                if(!dfs(visited, adjList, i)){
                    return false;
                }
            }
        }

        return true;
    }
}
