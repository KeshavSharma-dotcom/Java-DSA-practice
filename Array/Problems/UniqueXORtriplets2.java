public int uniqueXorTriplets(int[] nums) {
    int maxVal = 0;
    for (int num : nums) {
        maxVal = Math.max(maxVal, num);
    }
    int limit = 1;
    while (limit <= maxVal) {
        limit <<= 1;
    }
    boolean[] s1 = new boolean[limit];
    for (int a : nums) {
        for (int b : nums) {
            s1[a ^ b] = true;
        }
    }
    boolean[] s2 = new boolean[limit];
    for (int pair = 0; pair < limit; pair++) {
        if (s1[pair]) {
            for (int c : nums) {
                s2[pair ^ c] = true;
            }
        }
    }
    int uniqueCount = 0;
    for (int i = 0; i < limit; i++) {
        if (s2[i]) {
            uniqueCount++;
        }
    }
    return uniqueCount;
}

void main() {
    int[] h = {6,7,8,9};
    System.out.println(uniqueXorTriplets(h));
}