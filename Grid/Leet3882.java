public int minCost(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    BitSet[][] dp = new BitSet[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            dp[i][j] = new BitSet(1024);
        }
    }

    dp[0][0].set(grid[0][0]);

    for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
            if (r == 0 && c == 0)
                continue;

            int val = grid[r][c];
            BitSet combined = new BitSet(1024);

            if (r > 0)
                combined.or(dp[r - 1][c]);
            if (c > 0)
                combined.or(dp[r][c - 1]);

            for (int x = combined.nextSetBit(0); x >= 0; x = combined.nextSetBit(x + 1)) {
                dp[r][c].set(x ^ val);
            }
        }
    }

    return dp[m - 1][n - 1].nextSetBit(0);
}

void main() {
}