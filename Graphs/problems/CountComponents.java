public boolean isComplete(int startNode, List<List<Integer>> adj,int[] degrees,boolean[] visited){
    int node=0, degreeSum = 0;
    Queue<Integer> queue = new LinkedList<>();
    visited[startNode] = true;
    queue.offer(startNode);
    while(!queue.isEmpty()){
        int curr = queue.poll();
        degreeSum+= degrees[curr];
        node++;
        for(int neighbour : adj.get(curr)){
            if(!visited[neighbour]){
                visited[neighbour] = true;
                queue.offer(neighbour);
            }
        }
    }
    return degreeSum == (node * (node-1));
}
public int countCompleteComponents(int n, int[][] edges) {
    if(edges.length == 0){
        return n;
    }
    int[] degrees = new int[n];
    int component = 0;
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
    }
    for(int[] edge : edges){
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
        degrees[edge[0]]++;
        degrees[edge[1]]++;
    }
    boolean[] visited = new boolean[n];
    for(int i=0;i<n;i++){
        if(!visited[i]){
            if(isComplete(i,adj,degrees,visited)){
                component++;
            }
        }
    }
    return component;
}

void main() {
}