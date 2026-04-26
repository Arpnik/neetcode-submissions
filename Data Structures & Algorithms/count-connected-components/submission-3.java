class Solution {
    private void dfs(Map<Integer, List<Integer>> adjList, int current, boolean[] visited){
        if(visited[current])
            return;
        
        visited[current] = true;
        for(int connected: adjList.get(current)){
            dfs(adjList, connected, visited);
        }

    }

    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        boolean[] visited = new boolean[n];
        int i;
        for(i=0;i<n;i++){
            adjList.put(i, new ArrayList<Integer>());
            visited[i] = false;
        }
        int start, end;
        for(i=0;i<edges.length;i++){
            start = edges[i][0];
            end = edges[i][1];
            List<Integer> arr = adjList.get(start);
            arr.add(end);
            adjList.put(start, arr);
            arr = adjList.get(end);
            arr.add(start);
            adjList.put(end, arr);
        }

        int count = 0;
        for(i=0;i<n;i++){
            if(!visited[i]){
                count+=1;
                dfs(adjList, i, visited);
            }
        }

        return count;
    }
}
