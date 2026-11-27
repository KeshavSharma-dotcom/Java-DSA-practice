public int maximumSaleItems(int[][] items, int budget) {
    int n = items.length;
    int[] freeCount = new int[n];
    int minPrice = Integer.MAX_VALUE;

    // 1. Precompute free copies granted by buying at least one of item i
    for (int i = 0; i < n; i++) {
        minPrice = Math.min(minPrice, items[i][1]);
        for (int j = 0; j < n; j++) {
            if (i != j && items[j][0] % items[i][0] == 0) {
                freeCount[i]++;
            }
        }
    }

    int[] dp = new int[budget + 1];

    // 2. 0/1 Knapsack for the 1st copy of each item (triggers free copies)
    for (int i = 0; i < n; i++) {
        int price = items[i][1];
        int value = 1 + freeCount[i];
        for (int c = budget; c >= price; c--) {
            dp[c] = Math.max(dp[c], dp[c - price] + value);
        }
    }

    // 3. Unbounded Knapsack for extra copies (always optimal to buy the cheapest item)
    for (int c = minPrice; c <= budget; c++) {
        dp[c] = Math.max(dp[c], dp[c - minPrice] + 1);
    }

    return dp[budget];
}

void main() {
    int[][] items = {{6, 2}, {2, 6}, {3, 4}};
    int budget = 9;
    System.out.println(maximumSaleItems(items,budget));
}