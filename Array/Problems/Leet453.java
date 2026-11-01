public int minMoves(int[] nums) {
    int min = nums[0];
    for (int x : nums) {
        if (x < min) {
            min = x;
        }
    }

    int moves = 0;
    for (int x : nums) {
        moves += (x - min);
    }

    return moves;
}

void main() {
    int[] a = {2,4,6,8,1};
    System.out.println(minMoves(a));
}