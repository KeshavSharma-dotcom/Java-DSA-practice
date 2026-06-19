public int largestAltitude(int[] gain) {
    int startAlt = 0 ,highestAlt = Integer.MIN_VALUE;
    for (int j : gain) {
        int sum = startAlt + j;
        highestAlt = Math.max(highestAlt, sum);
        startAlt = sum;
    }
    return Math.max(highestAlt, 0);
}

void main() {
    int[] a= {-4,-3,-2,-1,4,3,2};
    System.out.println(largestAltitude(a));
}