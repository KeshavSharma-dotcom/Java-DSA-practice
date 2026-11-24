public int maxLength(int[] nums) {
    int n = nums.length;
    int maxLen = 1; // Any subarray of length 1 is trivially product equivalent

    // Max possible LCM of numbers in [1..10] is 2520, max GCD is 10.
    // Thus, lcm * gcd can never exceed 25200.
    int MAX_POSSIBLE_VAL = 25200;

    for (int i = 0; i < n; i++) {
        long prod = 1;
        int currentGcd = 0;
        int currentLcm = 1;

        for (int j = i; j < n; j++) {
            prod *= nums[j];

            // Prevent overflow and prune impossible subarrays early
            if (prod > MAX_POSSIBLE_VAL) {
                break;
            }

            currentGcd = gcd(currentGcd, nums[j]);
            currentLcm = lcm(currentLcm, nums[j]);

            if (prod == (long) currentLcm * currentGcd) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
    }

    return maxLen;
}

private int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

private int lcm(int a, int b) {
    return (a / gcd(a, b)) * b;
}

void main() {
    int[] a = {22,5,3,15,6,7};
    System.out.println(maxLength(a));
}