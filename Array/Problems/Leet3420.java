public long countNonDecreasingSubarrays(int[] nums, int k) {
    int n = nums.length;
    long totalSubarrays = 0;
    long currentCost = 0;

    // Monotonic non-decreasing deque from front (l) to back (r)
    // Stores {governing_max_value, count_of_elements}
    Deque<long[]> dq = new ArrayDeque<>();

    int r = n - 1;
    for (int l = n - 1; l >= 0; l--) {
        long val = nums[l];
        long count = 1;

        // nums[l] dominates all blocks to its right that have value <= nums[l]
        while (!dq.isEmpty() && dq.peekFirst()[0] <= val) {
            long[] front = dq.pollFirst();
            // Previously those front[1] elements were raised to front[0];
            // now they must be raised to 'val' instead.
            currentCost += front[1] * (val - front[0]);
            count += front[1];
        }

        dq.offerFirst(new long[]{val, count});

        // Shrink from the right while cost exceeds k
        while (currentCost > k) {
            long[] back = dq.peekLast();
            currentCost -= (back[0] - nums[r]);
            back[1]--;
            if (back[1] == 0) {
                dq.pollLast();
            }
            r--;
        }

        // All subarrays starting at l and ending in [l, r] are valid
        totalSubarrays += (r - l + 1);
    }

    return totalSubarrays;
}

void main() {
    int[] a = {6,3,1,2,4,4};
    System.out.println(countNonDecreasingSubarrays(a,7));
}
