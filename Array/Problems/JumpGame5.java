public int maxJumps(int[] arr, int d) {
    int n = arr.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    // Pair each index with its value: [value, index]
    int[][] sortedElements = new int[n][2];
    for (int i = 0; i < n; i++) {
        sortedElements[i][0] = arr[i];
        sortedElements[i][1] = i;
    }

    // Sort elements by their values in ascending order
    Arrays.sort(sortedElements, (a, b) -> Integer.compare(a[0], b[0]));

    int maxResult = 1;

    // Process indices from the smallest value to the largest value
    for (int[] element : sortedElements) {
        int i = element[1];

        // 1. Look Right up to 'd' steps
        for (int x = 1; x <= d; x++) {
            int j = i + x;
            if (j >= n) break; // Out of bounds
            if (arr[i] <= arr[j]) break; // Blocked: next element is equal or taller

            // If legal, element i can jump to j and inherit its path
            dp[i] = Math.max(dp[i], 1 + dp[j]);
        }

        // 2. Look Left up to 'd' steps
        for (int x = 1; x <= d; x++) {
            int j = i - x;
            if (j < 0) break; // Out of bounds
            if (arr[i] <= arr[j]) break; // Blocked: next element is equal or taller

            // If legal, element i can jump to j and inherit its path
            dp[i] = Math.max(dp[i], 1 + dp[j]);
        }

        // Keep track of the global maximum sequence length found
        maxResult = Math.max(maxResult, dp[i]);
    }

    return maxResult;
}
void main(){
    int[] t = {6,4,14,6,8,13,9,7,10,6,12};
    int Mj = maxJumps(t,2);
    System.out.println("Max jumps = "+Mj);

}