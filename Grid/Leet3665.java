private int m;
private int n;
private static final int MOD = 1_000_000_007;

public int uniquePaths(int[][] grid) {
    this.m = grid.length;
    this.n = grid[0].length;

    int[][] memo = new int[m][n];
    for (int i = 0; i < m; i++) {
        Arrays.fill(memo[i], -1);
    }

    return dfs(0, 0, grid, memo);
}

private int dfs(int r, int c, int[][] grid, int[][] memo) {
    // Base case: Reached the bottom-right corner
    if (r == m - 1 && c == n - 1) {
        return 1;
    }

    if (memo[r][c] != -1) {
        return memo[r][c];
    }

    long totalWays = 0;

    // Option 1: Move Right (dir = 0)
    int[] nextFromRight = simulateMove(r, c + 1, 0, grid);
    if (nextFromRight != null) {
        totalWays = (totalWays + dfs(nextFromRight[0], nextFromRight[1], grid, memo)) % MOD;
    }

    // Option 2: Move Down (dir = 1)
    int[] nextFromDown = simulateMove(r + 1, c, 1, grid);
    if (nextFromDown != null) {
        totalWays = (totalWays + dfs(nextFromDown[0], nextFromDown[1], grid, memo)) % MOD;
    }

    return memo[r][c] = (int) totalWays;
}

// Follows reflections until reaching an empty cell or going out of bounds.
// dir: 0 for RIGHT, 1 for DOWN.
private int[] simulateMove(int r, int c, int dir, int[][] grid) {
    while (r >= 0 && r < m && c >= 0 && c < n) {
        // Reached an empty cell or the destination
        if (grid[r][c] == 0) {
            return new int[]{r, c};
        }

        // Reflect on mirror
        if (dir == 0) {
            // Moving right hits mirror -> turns down
            r = r + 1;
            dir = 1;
        } else {
            // Moving down hits mirror -> turns right
            c = c + 1;
            dir = 0;
        }
    }

    // Stepped out of bounds
    return null;
}

void main() {
    int[][] grid = {{0,1},{0,0}};
    System.out.println(uniquePaths(grid));
}