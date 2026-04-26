class Solution {
    private static void dfs(Map<Integer, List<Integer>> adjList, boolean[] visited, int current, Integer previous, boolean[] isCycle){
        if(visited[current]){
            isCycle[0] = true;
            return;
        }

        visited[current]=true;
        for(int neighbour: adjList.get(current)){
            if(neighbour != previous){
                dfs(adjList, visited, neighbour, current, isCycle);
            }
        }
    }
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<Integer,List<Integer>>();
        boolean[] visited = new boolean[n];
        int i, start, end;
        List<Integer> nodes;
        for(i=0;i<n;i++){
            visited[i]=false;
            adjList.put(i, new LinkedList<Integer>());
        }
        for(int[] edge: edges){
            start = edge[0];
            end = edge[1];
            nodes = adjList.get(start);
            nodes.add(end);
            adjList.put(start, nodes);
            nodes = adjList.get(end);
            nodes.add(start);
            adjList.put(end, nodes);
        }

        boolean[] isCycle = new boolean[1];
        isCycle[0] = false;
        dfs(adjList, visited, 0, -1, isCycle);

        if(isCycle[0])
            return false;
        
        for(i=0; i<n; i++){
            if(!visited[i])
                return false;
        }

        return true;

    }
}
