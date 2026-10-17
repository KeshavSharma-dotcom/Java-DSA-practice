private static class Element {
    int val;
    int sum;
    int origIdx;

    Element(int val, int sum, int origIdx) {
        this.val = val;
        this.sum = sum;
        this.origIdx = origIdx;
    }
}

private int getDigitSum(int num) {
    int s = 0;
    while (num > 0) {
        s += num % 10;
        num /= 10;
    }
    return s;
}

public int minSwaps(int[] nums) {
    int n = nums.length;
    Element[] arr = new Element[n];

    for (int i = 0; i < n; i++) {
        arr[i] = new Element(nums[i], getDigitSum(nums[i]), i);
    }

    Arrays.sort(arr, (a, b) -> {
        if (a.sum != b.sum) {
            return Integer.compare(a.sum, b.sum);
        }
        return Integer.compare(a.val, b.val);
    });

    boolean[] visited = new boolean[n];
    int swaps = 0;

    for (int i = 0; i < n; i++) {
        if (visited[i] || arr[i].origIdx == i) {
            continue;
        }

        int cycleSize = 0;
        int curr = i;
        while (!visited[curr]) {
            visited[curr] = true;
            curr = arr[curr].origIdx;
            cycleSize++;
        }

        if (cycleSize > 1) {
            swaps += (cycleSize - 1);
        }
    }

    return swaps;
}

void main() {
    int[] a = {18,43,34,16};
    System.out.println(minSwaps(a));
}
