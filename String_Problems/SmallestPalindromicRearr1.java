public String smallestPalindrome(String s) {
    // Step 1: Count character frequencies
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
        count[c - 'a']++;
    }

    StringBuilder leftHalf = new StringBuilder();
    char midChar = 0;

    for (int i = 0; i < 26; i++) {
        if (count[i] % 2 != 0) {
            midChar = (char) ('a' + i);
        }
       for (int j = 0; j < count[i] / 2; j++) {
            leftHalf.append((char) ('a' + i));
        }
    }

    StringBuilder result = new StringBuilder(leftHalf);
    if (midChar != 0) {
        result.append(midChar);
    }
    result.append(new StringBuilder(leftHalf).reverse());

    return result.toString();
}

void main() {
    System.out.println(smallestPalindrome("yey"));
}