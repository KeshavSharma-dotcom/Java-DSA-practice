public int minMoves(String[] classroom, int energy) {
    int m = classroom.length;
    int n = classroom[0].length();

    int startR = -1, startC = -1;
    int litterCount = 0;
    int[][] litterIndex = new int[m][n];
    for (int[] row : litterIndex) {
        Arrays.fill(row, -1);
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            char ch = classroom[i].charAt(j);
            if (ch == 'S') {
                startR = i;
                startC = j;
            } else if (ch == 'L') {
                litterIndex[i][j] = litterCount++;
            }
        }
    }

    if (litterCount == 0) return 0;

    int targetMask = (1 << litterCount) - 1;
    int[][][] maxEnergy = new int[m][n][1 << litterCount];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            Arrays.fill(maxEnergy[i][j], -1);
        }
    }

    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{startR, startC, 0, energy, 0});
    maxEnergy[startR][startC][0] = energy;

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        int r = curr[0], c = curr[1], mask = curr[2], curEnergy = curr[3], steps = curr[4];

        if (mask == targetMask) {
            return steps;
        }

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
            char cell = classroom[nr].charAt(nc);
            if (cell == 'X') continue;

            int nextEnergy = curEnergy - 1;
            if (nextEnergy < 0) continue;

            if (cell == 'R') {
                nextEnergy = energy;
            }
            int nextMask = mask;
            if (cell == 'L' && litterIndex[nr][nc] != -1) {
                nextMask |= (1 << litterIndex[nr][nc]);
            }
            if (nextEnergy <= maxEnergy[nr][nc][nextMask]) continue;
            maxEnergy[nr][nc][nextMask] = nextEnergy;
            queue.offer(new int[]{nr, nc, nextMask, nextEnergy, steps + 1});
        }
    }

    return -1;
}

void main() {
}