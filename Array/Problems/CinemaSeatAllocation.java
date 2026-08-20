public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    Map<Integer, Integer> rowReservations = new HashMap<>();
    for (int[] seat : reservedSeats) {
        int row = seat[0];
        int col = seat[1];
        if (col >= 2 && col <= 9) {
            rowReservations.put(row, rowReservations.getOrDefault(row, 0) | (1 << (col - 1)));
        }
    }
    int maxGroups = (n - rowReservations.size()) * 2;
    int leftMask = (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4);
    int rightMask = (1 << 5) | (1 << 6) | (1 << 7) | (1 << 8);
    int middleMask = (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6);

    for (int reservedMask : rowReservations.values()) {
        boolean leftFree = (reservedMask & leftMask) == 0;
        boolean rightFree = (reservedMask & rightMask) == 0;
        boolean middleFree = (reservedMask & middleMask) == 0;

        if (leftFree && rightFree) {
            maxGroups += 2;
        } else if (leftFree || rightFree || middleFree) {
            maxGroups += 1;
        }
    }
    return maxGroups;
}

void main() {
}