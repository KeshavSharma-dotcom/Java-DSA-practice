public int[] validSequence(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();

    int[] right = new int[m];
    Arrays.fill(right, -1);

    int p1 = n - 1;
    for (int j = m - 1; j >= 0; j--) {
        while (p1 >= 0 && word1.charAt(p1) != word2.charAt(j)) {
            p1--;
        }
        if (p1 < 0) break;
        right[j] = p1;
        p1--;
    }

    int[] ans = new int[m];
    boolean changed = false;
    p1 = 0;

    for (int i = 0; i < m; i++) {
        if (p1 < n && word1.charAt(p1) == word2.charAt(i)) {
            ans[i] = p1;
            p1++;
        } else {
            boolean canChange = !changed && (p1 < n) &&
                    (i + 1 == m || (right[i + 1] != -1 && right[i + 1] > p1));

            if (canChange) {
                ans[i] = p1;
                changed = true;
                p1++;
            } else {
                while (p1 < n && word1.charAt(p1) != word2.charAt(i)) {
                    p1++;
                }
                if (p1 >= n) return new int[0];
                ans[i] = p1;
                p1++;
            }
        }
    }

    return ans;
}

void main() {
    System.out.println(Arrays.toString(validSequence("abcdef","abcfg")));
}