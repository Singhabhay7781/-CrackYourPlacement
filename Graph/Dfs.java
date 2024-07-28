

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[] = new int[V];
        ArrayList<Integer> dfs = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(vis[i] != 1){
                dfs(adj,vis,dfs,i);
            }
        }
        return dfs;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj,int[] vis
    ,ArrayList<Integer> dfs,int node){
        vis[node] = 1;
        dfs.add(node);
        for(int j=0;j<adj.get(node).size();j++){
            if(vis[adj.get(node).get(j)] != 1){
                dfs(adj,vis,dfs,adj.get(node).get(j));
            }
        }
    }
}