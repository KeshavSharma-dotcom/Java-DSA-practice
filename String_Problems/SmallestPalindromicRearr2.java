private static final long CAP = 1_000_001L;

public String smallestPalindrome(String s, int k) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) {
        freq[c - 'a']++;
    }

    int[] halfFreq = new int[26];
    int halfLen = 0;
    char midChar = 0;

    for (int i = 0; i < 26; i++) {
        halfFreq[i] = freq[i] / 2;
        halfLen += halfFreq[i];
        if (freq[i] % 2 != 0) {
            midChar = (char) ('a' + i);
        }
    }

    if (countWays(halfFreq, halfLen) < k) {
        return "";
    }

    StringBuilder leftHalf = new StringBuilder();

    for (int pos = 0; pos < halfLen; pos++) {
        for (int c = 0; c < 26; c++) {
            if (halfFreq[c] == 0) continue;

            halfFreq[c]--;
            long ways = countWays(halfFreq, halfLen - pos - 1);

            if (ways >= k) {
                leftHalf.append((char) ('a' + c));
                break;
            } else {
                k -= ways;
                halfFreq[c]++;
            }
        }
    }

    StringBuilder result = new StringBuilder(leftHalf);
    if (midChar != 0) {
        result.append(midChar);
    }
    result.append(new StringBuilder(leftHalf).reverse());

    return result.toString();
}

private long countWays(int[] freq, int total) {
    long res = 1;
    int rem = total;

    for (int i = 0; i < 26; i++) {
        int count = freq[i];
        for (int j = 1; j <= count; j++) {
            res = res * (rem - count + j) / j;
            if (res > CAP) return CAP;
        }
        rem -= count;
    }
    return res;
}

void main() {
}