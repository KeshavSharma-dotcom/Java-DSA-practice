public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
    int n = nums1.length;
    int maxDiff = 0;
    int[] diffs = new int[n];

    for (int i = 0; i < n; i++) {
        diffs[i] = Math.abs(nums1[i] - nums2[i]);
        if (diffs[i] > maxDiff) {
            maxDiff = diffs[i];
        }
    }

    int[] count = new int[maxDiff + 1];
    for (int d : diffs) {
        count[d]++;
    }

    long k = (long) k1 + k2;

    for (int d = maxDiff; d > 0 && k > 0; d--) {
        if (count[d] == 0) continue;

        long take = Math.min((long) count[d], k);
        count[d] -= (int) take;
        count[d - 1] += (int) take;
        k -= take;

        if (count[d] > 0) {
            break;
        }
    }

    long ans = 0;
    for (int d = 1; d <= maxDiff; d++) {
        if (count[d] > 0) {
            ans += (long) count[d] * d * d;
        }
    }

    return ans;
}

void main() {
}