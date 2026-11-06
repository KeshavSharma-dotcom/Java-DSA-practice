public int[] countServers(int n, int[][] logs, int x, int[] queries) {
    int m = queries.length;
    // Pair queries with their original index: [time, index]
    int[][] sortedQueries = new int[m][2];
    for (int i = 0; i < m; i++) {
        sortedQueries[i][0] = queries[i];
        sortedQueries[i][1] = i;
    }
    Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

    // Sort logs by time: [server_id, time]
    Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

    int[] ans = new int[m];
    int[] serverCount = new int[n + 1];
    int activeServers = 0;
    int l = 0, r = 0;
    int numLogs = logs.length;

    for (int[] query : sortedQueries) {
        int qTime = query[0];
        int origIdx = query[1];
        int leftTime = qTime - x;

        // Expand right boundary: add logs with time <= qTime
        while (r < numLogs && logs[r][1] <= qTime) {
            int sId = logs[r][0];
            if (serverCount[sId] == 0) {
                activeServers++;
            }
            serverCount[sId]++;
            r++;
        }

        // Shrink left boundary: remove logs with time < qTime - x
        while (l < numLogs && logs[l][1] < leftTime) {
            int sId = logs[l][0];
            serverCount[sId]--;
            if (serverCount[sId] == 0) {
                activeServers--;
            }
            l++;
        }

        ans[origIdx] = n - activeServers;
    }

    return ans;
}

void main() {
}