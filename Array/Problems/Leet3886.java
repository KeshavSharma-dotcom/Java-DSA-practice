public int sortableIntegers(int[] nums) {
    int n = nums.length;
    int totalSum = 0;

    for (int k = 1; k <= n; k++) {
        if (n % k != 0) {
            continue;
        }

        boolean sortable = true;
        int prevMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i += k) {
            int drops = 0;
            int curMin = Integer.MAX_VALUE;
            int curMax = Integer.MIN_VALUE;

            for (int j = 0; j < k; j++) {
                int val = nums[i + j];
                curMin = Math.min(curMin, val);
                curMax = Math.max(curMax, val);

                int nextVal = nums[i + (j + 1) % k];
                if (val > nextVal) {
                    drops++;
                }
            }

            if (drops > 1 || curMin < prevMax) {
                sortable = false;
                break;
            }

            prevMax = curMax;
        }

        if (sortable) {
            totalSum += k;
        }
    }

    return totalSum;
}

void main() {
}