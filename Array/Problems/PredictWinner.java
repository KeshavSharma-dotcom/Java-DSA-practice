//public boolean predictTheWinner(int[] nums) {
//    int n = nums.length;
//    int[][] dp = new int[n][n];
//
//    for (int i = 0; i < n; i++) {
//        dp[i][i] = nums[i];
//    }
//
//    for (int len = 2; len <= n; len++) {
//        for (int i = 0; i + len - 1 < n; i++) {
//            int j = i + len - 1;
//
//            int pickLeft = nums[i] - dp[i + 1][j];
//            int pickRight = nums[j] - dp[i][j - 1];
//
//            dp[i][j] = Math.max(pickLeft, pickRight);
//        }
//    }
//
//    return dp[0][n - 1] >= 0;
//}

public boolean predictTheWinner(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];

    for (int i = n - 1; i >= 0; i--) {
        dp[i] = nums[i];
        for (int j = i + 1; j < n; j++) {
            dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
        }
    }

    return dp[n - 1] >= 0;
}

void main() {
    int[] a = {1,5,233,7};
    System.out.println(predictTheWinner(a));
}