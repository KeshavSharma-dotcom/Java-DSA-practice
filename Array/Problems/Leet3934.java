private static final long MOD1 = 1_000_000_007L;
private static final long MOD2 = 1_000_000_009L;
private static final long BASE1 = 1_000_000_021L;
private static final long BASE2 = 1_000_000_033L;

public static int smallestUniqueSubarray(int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;

    // Fast O(n) check for length 1
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    for (int count : freq.values()) {
        if (count == 1) return 1;
    }

    int low = 2, high = n;
    int ans = n; // The entire array of length n is always unique

    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (hasUniqueSubarray(nums, mid)) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return ans;
}

private static boolean hasUniqueSubarray(int[] arr, int length) {
    int n = arr.length;
    long h1 = 0, h2 = 0;
    long p1 = modPow(BASE1, length - 1, MOD1);
    long p2 = modPow(BASE2, length - 1, MOD2);

    // Hash the first window [0 ... length - 1]
    for (int i = 0; i < length; i++) {
        long val = (arr[i] + 1L); // +1 avoids 0-value collisions
        h1 = (h1 * BASE1 + (val % MOD1)) % MOD1;
        h2 = (h2 * BASE2 + (val % MOD2)) % MOD2;
    }

    Map<Long, Integer> seen = new HashMap<>(n - length + 1);
    long initialKey = (h1 << 32) | h2;
    seen.put(initialKey, 1);

    // Slide the window across the rest of the array
    for (int i = length; i < n; i++) {
        long outVal = arr[i - length] + 1L;
        long inVal = arr[i] + 1L;

        // Remove outgoing element (adding MOD prevents negative results in Java)
        h1 = (h1 - ((outVal % MOD1) * p1) % MOD1 + MOD1) % MOD1;
        h2 = (h2 - ((outVal % MOD2) * p2) % MOD2 + MOD2) % MOD2;

        // Shift and add incoming element
        h1 = (h1 * BASE1 + (inVal % MOD1)) % MOD1;
        h2 = (h2 * BASE2 + (inVal % MOD2)) % MOD2;

        long key = (h1 << 32) | h2;
        seen.put(key, seen.getOrDefault(key, 0) + 1);
    }

    for (int count : seen.values()) {
        if (count == 1) return true;
    }
    return false;
}

private static long modPow(long base, int exp, long mod) {
    long result = 1;
    base %= mod;
    while (exp > 0) {
        if ((exp & 1) == 1) {
            result = (result * base) % mod;
        }
        base = (base * base) % mod;
        exp >>= 1;
    }
    return result;
}

void main() {
}