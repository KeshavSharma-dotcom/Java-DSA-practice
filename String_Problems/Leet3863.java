public int minOperations(String s) {
    int n = s.length();
    char[] arr = s.toCharArray();
    char[] sorted = s.toCharArray();
    Arrays.sort(sorted);

    if (Arrays.equals(arr, sorted)) {
        return 0;
    }

    if (n == 2) {
        return -1;
    }
    int L = 0;
    while (L < n && arr[L] == sorted[L]) {
        L++;
    }
    int R = n - 1;
    while (R >= 0 && arr[R] == sorted[R]) {
        R--;
    }
    if (L > 0 || R < n - 1) {
        return 1;
    }

    char minChar = sorted[0];
    char maxChar = sorted[n - 1];

    if (arr[0] == maxChar && arr[n - 1] == minChar) {
        boolean minAvailable = false;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == minChar) {
                minAvailable = true;
                break;
            }
        }

        boolean maxAvailable = false;
        for (int i = 1; i < n; i++) {
            if (arr[i] == maxChar) {
                maxAvailable = true;
                break;
            }
        }

        if (!minAvailable && !maxAvailable) {
            return 3;
        }
    }

    return 2;
}

void main() {
    System.out.println(minOperations("Helium"));
}