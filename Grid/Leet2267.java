private Boolean[][][] memo;
        private int m, n;

public boolean hasValidPath(char[][] grid) {
    m = grid.length;
    n = grid[0].length;

    // Path length is m + n - 1; valid parentheses string must have even length
    if ((m + n - 1) % 2 != 0) return false;

    // Start must be '(' and end must be ')'
    if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

    // Max possible open balance is (m + n) / 2
    int maxBal = (m + n) / 2;
    memo = new Boolean[m][n][maxBal + 1];

    return dfs(grid, 0, 0, 0);
}

private boolean dfs(char[][] grid, int r, int c, int bal) {
    // Update balance
    bal += (grid[r][c] == '(' ? 1 : -1);

    // Balance cannot go negative
    if (bal < 0) return false;

    // Remaining steps to reach (m - 1, n - 1)
    int remainingSteps = (m - 1 - r) + (n - 1 - c);

    // If balance exceeds remaining steps, we cannot close all '('
    if (bal > remainingSteps) return false;

    // Base case: destination cell reached
    if (r == m - 1 && c == n - 1) {
        return bal == 0;
    }

    // Return cached result if already computed
    if (memo[r][c][bal] != null) {
        return memo[r][c][bal];
    }

    boolean found = false;

    // Move Down
    if (r + 1 < m) {
        found = dfs(grid, r + 1, c, bal);
    }

    // Move Right (if not already found)
    if (!found && c + 1 < n) {
        found = dfs(grid, r, c + 1, bal);
    }

    return memo[r][c][bal] = found;
}

void main() {
}