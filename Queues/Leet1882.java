public int[] assignTasks(int[] servers, int[] tasks) {
    int n = servers.length;
    int m = tasks.length;

    // freeServers: stores [weight, index]
    // sorted by weight ascending, then index ascending
    PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
        if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
        return Integer.compare(a[1], b[1]);
    });

    for (int i = 0; i < n; i++) {
        freeServers.offer(new int[]{servers[i], i});
    }

    // busyServers: stores [freeTime, weight, index]
    // sorted by freeTime ascending, then weight, then index
    PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> {
        if (a[0] != b[0]) return Long.compare(a[0], b[0]);
        if (a[1] != b[1]) return Long.compare(a[1], b[1]);
        return Long.compare(a[2], b[2]);
    });

    int[] ans = new int[m];
    long curTime = 0;

    for (int j = 0; j < m; j++) {
        curTime = Math.max(curTime, (long) j);

        // Jump forward if all servers are busy
        if (freeServers.isEmpty()) {
            curTime = busyServers.peek()[0];
        }

        // Free all servers that have finished before or at curTime
        while (!busyServers.isEmpty() && busyServers.peek()[0] <= curTime) {
            long[] done = busyServers.poll();
            freeServers.offer(new int[]{(int) done[1], (int) done[2]});
        }

        // Allocate task to best server
        int[] server = freeServers.poll();
        ans[j] = server[1];
        busyServers.offer(new long[]{curTime + tasks[j], server[0], server[1]});
    }

    return ans;
}

void main() {
    int[] servers1 = {3, 3, 2};
    int[] tasks1 = {1, 2, 3, 2, 1, 2};
    System.out.println(Arrays.toString(assignTasks(servers1,tasks1)));
}