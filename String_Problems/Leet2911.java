public int minimumChanges(String s, int k) {
    int n = s.length();
    char[] chars = s.toCharArray();
    int INF = 1_000_000;

    int[][] cost = new int[n][n];
    for (int[] row : cost) {
        Arrays.fill(row, INF);
    }

    for (int len = 2; len <= n; len++) {
        for (int d = 1; d < len; d++) {
            if (len % d != 0) continue;

            int groupLen = len / d;
            for (int i = 0; i + len <= n; i++) {
                int changes = 0;
                for (int offset = 0; offset < d; offset++) {
                    int left = i + offset;
                    int right = i + offset + (groupLen - 1) * d;
                    while (left < right) {
                        if (chars[left] != chars[right]) {
                            changes++;
                        }
                        left += d;
                        right -= d;
                    }
                }
                cost[i][i + len - 1] = Math.min(cost[i][i + len - 1], changes);
            }
        }
    }

    int[][] dp = new int[k + 1][n + 1];
    for (int[] row : dp) {
        Arrays.fill(row, INF);
    }
    dp[0][0] = 0;

    for (int p = 1; p <= k; p++) {
        for (int i = 2 * p; i <= n; i++) {
            for (int m = 2 * (p - 1); m <= i - 2; m++) {
                if (dp[p - 1][m] != INF && cost[m][i - 1] != INF) {
                    dp[p][i] = Math.min(dp[p][i], dp[p - 1][m] + cost[m][i - 1]);
                }
            }
        }
    }

    return dp[k][n];
}

void main() {
    System.out.println(minimumChanges("bba",1));
}