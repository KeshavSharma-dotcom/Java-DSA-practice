public int minMoves(int[] nums) {
    int max = 0;
    int sum = 0;
    for (int num : nums) {
        sum += num;
        if (max < num) {
            max = num;
        }
    }
    return (max*nums.length - sum);
}

void main() {
    int[] a = {2,3,1};
    System.out.println(minMoves(a));
}