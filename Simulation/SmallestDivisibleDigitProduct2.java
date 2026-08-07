public String smallestNumber(String num, long t) {
    long tempT = t;
    int count2 = 0, count3 = 0, count5 = 0, count7 = 0;

    while (tempT % 2 == 0) { count2++; tempT /= 2; }
    while (tempT % 3 == 0) { count3++; tempT /= 3; }
    while (tempT % 5 == 0) { count5++; tempT /= 5; }
    while (tempT % 7 == 0) { count7++; tempT /= 7; }

    if (tempT > 1) {
        return "-1";
    }

    int n = num.length();
    int zeroIdx = num.indexOf('0');
    int maxMatch = (zeroIdx == -1) ? n : zeroIdx;

    int[] p2 = new int[n + 1];
    int[] p3 = new int[n + 1];
    int[] p5 = new int[n + 1];
    int[] p7 = new int[n + 1];

    for (int i = 0; i < maxMatch; i++) {
        int d = num.charAt(i) - '0';
        p2[i + 1] = p2[i] + getFactorCount(d, 2);
        p3[i + 1] = p3[i] + getFactorCount(d, 3);
        p5[i + 1] = p5[i] + getFactorCount(d, 5);
        p7[i + 1] = p7[i] + getFactorCount(d, 7);
    }

    for (int i = maxMatch; i >= 0; i--) {
        int rem2 = Math.max(0, count2 - p2[i]);
        int rem3 = Math.max(0, count3 - p3[i]);
        int rem5 = Math.max(0, count5 - p5[i]);
        int rem7 = Math.max(0, count7 - p7[i]);

        int startDigit = (i == n) ? 10 : (i < maxMatch ? (num.charAt(i) - '0' + 1) : 1);

        for (int d = (i == n ? 10 : (i < n ? Math.max(1, (i < maxMatch ? num.charAt(i) - '0' + 1 : 1)) : 10)); d <= 9; d++) {
            int next2 = Math.max(0, rem2 - getFactorCount(d, 2));
            int next3 = Math.max(0, rem3 - getFactorCount(d, 3));
            int next5 = Math.max(0, rem5 - getFactorCount(d, 5));
            int next7 = Math.max(0, rem7 - getFactorCount(d, 7));

            int lenLeft = n - 1 - i;
            if (canSatisfy(next2, next3, next5, next7, lenLeft)) {
                StringBuilder sb = new StringBuilder();
                sb.append(num, 0, i);
                sb.append(d);
                sb.append(constructMinSuffix(next2, next3, next5, next7, lenLeft));
                return sb.toString();
            }
        }

        if (i == n && canSatisfy(rem2, rem3, rem5, rem7, 0)) {
            return num;
        }
    }

    for (int len = n + 1; ; len++) {
        if (canSatisfy(count2, count3, count5, count7, len)) {
            return constructMinSuffix(count2, count3, count5, count7, len);
        }
    }
}

private int minDigitsNeeded(int r2, int r3, int r5, int r7) {

    int digits = r5 + r7;
    digits += (r3 + 1) / 2;

    int rem3 = r3 % 2;
    int rem2 = r2;

    if (rem3 == 1) {
        if (rem2 == 1) { rem2 -= 1; digits++; }
        else if (rem2 >= 2) { rem2 -= 2; digits++; }
        else { digits++; }
    }
    digits += (rem2 + 2) / 3;
    return digits;
}

private boolean canSatisfy(int r2, int r3, int r5, int r7, int lenLeft) {
    return minDigitsNeeded(r2, r3, r5, r7) <= lenLeft;
}

private String constructMinSuffix(int r2, int r3, int r5, int r7, int len) {
    char[] res = new char[len];
    Arrays.fill(res, '1');

    int idx = len - 1;

    while (r7 > 0) { res[idx--] = '7'; r7--; }
    while (r5 > 0) { res[idx--] = '5'; r5--; }

    while (r3 >= 2) { res[idx--] = '9'; r3 -= 2; }

    while (r2 >= 3) { res[idx--] = '8'; r2 -= 3; }

    if (r3 == 1 && r2 == 1) { res[idx--] = '6'; r3--; r2--; }
    else if (r3 == 1 && r2 == 2) { res[idx--] = '6'; res[idx--] = '2'; r3--; r2 -= 2; }
    else if (r3 == 1) { res[idx--] = '3'; r3--; }

    if (r2 == 2) { res[idx--] = '4'; r2 -= 2; }
    else if (r2 == 1) { res[idx--] = '2'; r2 -= 1; }

    Arrays.sort(res);
    return new String(res);
}

private int getFactorCount(int digit, int prime) {
    if (digit <= 0) return 0;
    int count = 0;
    while (digit % prime == 0) {
        count++;
        digit /= prime;
    }
    return count;
}

void main() {
    System.out.println(smallestNumber("1234",256));
}