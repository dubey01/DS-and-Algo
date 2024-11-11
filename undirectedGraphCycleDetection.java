// Cycle detection in an undirected graph

// 1. BFS traversal approach

class Solution {
    // Function to detect cycle in an undirected graph.
    
    // BFS traversal Approach
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        
        boolean [] visited = new boolean[adj.size()];
        int parent = -1;
        
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                if(bfs(i, parent, adj, visited)) return true;
            }
        }
        
        return false;
        
    }
    
    boolean bfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean [] visited){
        Queue<Pair> q = new LinkedList();
        
        q.add(new Pair(node, parent));
        visited[node] = true;
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int child = pair.child();
            int childParent = pair.parent();
            
            for(int adjNode : adj.get(child)){
                if(!visited[adjNode]){
                    q.add(new Pair(adjNode, child));
                    visited[adjNode] = true;
                }
                else{
                    if(adjNode != childParent){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    class Pair{
        int child;
        int parent;
        
        Pair(int child, int parent){
            this.child = child;
            this.parent = parent;
        }
        
        public int child(){
            return this.child;
        }
        
        public int parent(){
            return this.parent;
        }
    }
}

// 2. DFS traversal approach

class Solution {
    // Function to detect cycle in an undirected graph.
    
    // DFS traversal approach
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        
        boolean [] visited = new boolean[adj.size()];
        int parent = -1;
        
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                if(dfs(i, parent, adj, visited)) return true;
            }
        }
        
        return false;
    }
    
    boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean [] visited){
        visited[node] = true;
        
        for(int adjNode : adj.get(node)){
            if(!visited[adjNode]){
                if(dfs(adjNode, node, adj, visited)) return true;
            }
            else{
                if(adjNode != parent){
                    return true;
                }
            }
        }
        
        return false;
    }
}
