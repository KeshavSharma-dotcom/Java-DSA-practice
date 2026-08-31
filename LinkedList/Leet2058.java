static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
static class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstIndex = -1;
        int prevIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        int currentIndex = 1;

        while (curr.next != null) {
            ListNode next = curr.next;

            boolean isMaxima = curr.val > prev.val && curr.val > next.val;
            boolean isMinima = curr.val < prev.val && curr.val < next.val;

            if (isMaxima || isMinima) {
                if (firstIndex == -1) {
                    firstIndex = currentIndex;
                } else {
                    minDistance = Math.min(minDistance, currentIndex - prevIndex);
                }
                prevIndex = currentIndex;
            }

            prev = curr;
            curr = next;
            currentIndex++;
        }

        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        int maxDistance = prevIndex - firstIndex;
        return new int[]{minDistance, maxDistance};
    }
}

public static ListNode createLinkedList(int[] values) {
    if (values == null || values.length == 0) return null;
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    for (int val : values) {
        current.next = new ListNode(val);
        current = current.next;
    }
    return dummy.next;
}

void main() {
    Solution solver = new Solution();

    int[] arr1 = {5, 3, 1, 2, 5, 1, 2};
    ListNode head1 = createLinkedList(arr1);
    int[] res1 = solver.nodesBetweenCriticalPoints(head1);
    System.out.println("Test 1: " + Arrays.toString(res1));

    int[] arr2 = {3, 1};
    ListNode head2 = createLinkedList(arr2);
    int[] res2 = solver.nodesBetweenCriticalPoints(head2);
    System.out.println("Test 2: " + Arrays.toString(res2));

    int[] arr3 = {1, 3, 2, 2, 3, 2, 2, 2, 7};
    ListNode head3 = createLinkedList(arr3);
    int[] res3 = solver.nodesBetweenCriticalPoints(head3);
    System.out.println("Test 3: " + Arrays.toString(res3));
}