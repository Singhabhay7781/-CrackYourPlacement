class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int vis[] = new int[V];
        q.add(0);
        vis[0] = 1;
      
        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);
            for(int i : adj.get(node)){
               if(vis[i] != 1){
                    q.add(i);
                    vis[i] = 1;
               }
            }
        }
        return bfs;
    }
}