public int maxSelectedElements(int[] nums) {
    Arrays.sort(nums);

    int maxVal = nums[nums.length - 1];
    int[] dp = new int[maxVal + 2];
    int maxConsecutive = 1;

    for (int x : nums) {
        dp[x + 1] = dp[x] + 1;

        dp[x] = dp[x - 1] + 1;

        maxConsecutive = Math.max(maxConsecutive, Math.max(dp[x], dp[x + 1]));
    }
    return maxConsecutive;
}

void main() {
    int[] t = {2,1,5,1,1};
    System.out.println(maxSelectedElements(t));
}