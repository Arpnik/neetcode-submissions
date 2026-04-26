// import java.util.*;

class Solution {

    private int getParent(int[] quickUnion, int index){
        while(index != quickUnion[index]){
            index = quickUnion[index];
        }
        
        return index;
    }

    public int countComponents(int n, int[][] edges) {
        int[] quickUnion = new int[n];
        int i, start, end;
        for(i=0;i<n;i++)
            quickUnion[i]=i;
        
        for(int[] edge: edges){
            start = edge[0];
            end = edge[1];
            int rootStart = getParent(quickUnion, start);
            int rootEnd = getParent(quickUnion, end);
            if(rootStart < rootEnd){
                quickUnion[rootEnd] = rootStart;
            } else {
                quickUnion[rootStart] = rootEnd;
            }
        }

        Set<Integer> parents = new HashSet<Integer>();
        for(i=0;i<n;i++){
            System.out.println(i+" "+quickUnion[i]);
            parents.add(getParent(quickUnion, i));
        }

        return parents.size();

    }
}
