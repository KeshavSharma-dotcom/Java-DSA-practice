public int maximumSafenessFactor(List<List<Integer>> grid) {
    int n = grid.size();
    int[][] safeness = new int[n][n];
    Queue<int[]> queue = new ArrayDeque<>();
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for(int[] row : safeness){
        Arrays.fill(row,-1);
    }

    for(int i=0;i<grid.size();i++){
        for(int j=0;j<grid.get(i).size();j++){
            if(grid.get(i).get(j) == 1){
                queue.add(new int[]{i,j});
                safeness[i][j] = 0;
            }
        }
    }
    while(!queue.isEmpty()){
        int[] curr = queue.poll();
        int r = curr[0];
        int c = curr[1];
        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                if(safeness[nr][nc] == -1){
                    safeness[nr][nc] = safeness[r][c] + 1;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
    }
    if (safeness[0][0] == 0 || safeness[n - 1][n - 1] == 0) {
        return 0;
    }
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->b[2]-a[2]);
    boolean[][] visited = new boolean[n][n];
    priorityQueue.add(new int[]{0,0,safeness[0][0]});
    while(!priorityQueue.isEmpty()){
        int[] curr = priorityQueue.poll();
        int r = curr[0];
        int c = curr[1];
        int weight = curr[2];
        if(r == n-1 && c == n-1){
            return weight;
        }
        if (visited[r][c]) continue;
        visited[r][c] = true;
        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]){
                priorityQueue.add(new int[]{nr,nc,Math.min(weight,safeness[nr][nc])});
            }
        }
    }
    return 0;
}

void main() {
    int[][] grid = {{0, 0, 1}, {0, 0, 0}, {0, 0, 0}};
    List<List<Integer>> list = Arrays.stream(grid)
            .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
            .toList();
    System.out.println(maximumSafenessFactor(list));
}