// 1. DFS Approach

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean [] visited = new boolean[adj.size()];
        boolean [] pathVisited = new boolean[adj.size()];
        
        
        for(int i=0; i<adj.size(); i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, pathVisited)) return true;
            }
        }
        
        return false;
        
    }
    
    boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean [] visited, boolean [] pathVisited){
        visited[node] = true;
        pathVisited[node] = true;
        
        for(int adjNode : adj.get(node)){
            if(!visited[adjNode]){
                if(dfs(adjNode, adj, visited, pathVisited)) return true;
            }
            else{
                if(pathVisited[adjNode]){
                    return true;
                }
            }
        }
        
        pathVisited[node] = false;
        
        return false;
    }
}

// 2. BFS Approach (Kahn's Algorithm)

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int [] inDegree = new int[adj.size()];
        
        for(int i=0; i<adj.size(); i++){
            for(int adjNode : adj.get(i)){
                inDegree[adjNode]++;
            }
        }
        
        return bfs(adj, inDegree);
        
    }
    
    boolean bfs(ArrayList<ArrayList<Integer>> adj, int [] inDegree){
        
        Queue<Integer> q = new LinkedList();
        
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0) q.add(i);
        }
        
        int count = 0;
        
        while(!q.isEmpty()){
            
            int front = q.poll();
            count++;
            
            for(int adjNode : adj.get(front)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0) q.add(adjNode);
            }
        }
        
        if(count == adj.size()) return false;
        
        return true;
    }
}
