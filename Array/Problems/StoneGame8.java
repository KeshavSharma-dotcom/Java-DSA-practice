public int stoneGameVIII(int[] stones) {
    int n = stones.length;
    int[] pref = new int[n];
    pref[0] = stones[0];
    for (int i = 1; i < n; i++) {
        pref[i] = pref[i - 1] + stones[i];
    }

    int maxDiff = pref[n - 1];
    for (int i = n - 2; i >= 1; i--) {
        maxDiff = Math.max(maxDiff, pref[i] - maxDiff);
    }

    return maxDiff;
}

void main() {
    int[] a = {7,-6,5,10,5,-2,-6};
    System.out.println(stoneGameVIII(a));
}