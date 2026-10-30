public int shortestPath(int n, int[][] edges, String labels, int k) {
    if (n == 1) return 0;

    List<int[]>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        graph[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
        graph[edge[0]].add(new int[]{edge[1], edge[2]});
    }

    int[][] dist = new int[n][k + 1];
    for (int i = 0; i < n; i++) {
        Arrays.fill(dist[i], Integer.MAX_VALUE);
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

    dist[0][1] = 0;
    pq.offer(new int[]{0, 0, 1});

    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int d = curr[0];
        int u = curr[1];
        int streak = curr[2];

        if (u == n - 1) {
            return d;
        }

        if (d > dist[u][streak]) {
            continue;
        }

        for (int[] edge : graph[u]) {
            int v = edge[0];
            int weight = edge[1];

            int nextStreak = (labels.charAt(v) == labels.charAt(u)) ? streak + 1 : 1;

            if (nextStreak <= k && d + weight < dist[v][nextStreak]) {
                dist[v][nextStreak] = d + weight;
                pq.offer(new int[]{dist[v][nextStreak], v, nextStreak});
            }
        }
    }

    return -1;
}

void main() {

}