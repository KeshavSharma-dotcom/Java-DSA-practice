public int minOperations(int[] nums) {
    int n = nums.length;
    if (n <= 1) return 0;

    int idx0 = 0;
    for (int i = 0; i < n; i++) {
        if (nums[i] == 0) {
            idx0 = i;
            break;
        }
    }

    boolean isInc = true;
    for (int j = 0; j < n; j++) {
        if (nums[(idx0 + j) % n] != j) {
            isInc = false;
            break;
        }
    }

    if (isInc) {
        if (idx0 == 0) return 0;
        return Math.min(idx0, (n - idx0) + 2);
    }

    boolean isDec = true;
    for (int j = 0; j < n; j++) {
        if (nums[(idx0 - j + n) % n] != j) {
            isDec = false;
            break;
        }
    }

    if (isDec) {
        int op1 = (n - idx0);
        int op2 = ((idx0 + 1) % n) + 1;
        return Math.min(op1, op2);
    }

    return -1;
}

void main() {
    int[] a = {2,3,4,5,6,7,0,1};
    System.out.println(minOperations(a));
}