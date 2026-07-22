static class Group {
    int start, end, len;
    Group(int start, int end) {
        this.start = start;
        this.end = end;
        this.len = end - start + 1;
    }
}

static class SegmentTree {
    int n;
    int[] tree;

    SegmentTree(int[] arr) {
        this.n = arr.length;
        if (n == 0) return;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, 2 * node + 1, start, mid);
        build(arr, 2 * node + 2, mid + 1, end);
        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public int query(int ql, int qr) {
        if (n == 0 || ql > qr || ql < 0 || qr >= n) return 0;
        return query(0, 0, n - 1, ql, qr);
    }

    private int query(int node, int start, int end, int ql, int qr) {
        if (qr < start || end < ql) return 0;
        if (ql <= start && end <= qr) return tree[node];
        int mid = (start + end) / 2;
        int leftMax = query(2 * node + 1, start, mid, ql, qr);
        int rightMax = query(2 * node + 2, mid + 1, end, ql, qr);
        return Math.max(leftMax, rightMax);
    }
}

public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
    int n = s.length();
    int totalOnesInS = 0;
    for (int i = 0; i < n; i++) {
        if (s.charAt(i) == '1') totalOnesInS++;
    }

    List<Group> zeroGroups = new ArrayList<>();
    int i = 0;
    while (i < n) {
        if (s.charAt(i) == '0') {
            int j = i;
            while (j < n && s.charAt(j) == '0') j++;
            zeroGroups.add(new Group(i, j - 1));
            i = j;
        } else {
            i++;
        }
    }

    int m = zeroGroups.size();

    int[] adjSums = new int[Math.max(0, m - 1)];
    for (int k = 0; k < m - 1; k++) {
        adjSums[k] = zeroGroups.get(k).len + zeroGroups.get(k + 1).len;
    }

    SegmentTree st = new SegmentTree(adjSums);
    List<Integer> ans = new ArrayList<>(queries.length);

    for (int[] q : queries) {
        int l = q[0], r = q[1];

        if (m < 2) {
            ans.add(totalOnesInS);
            continue;
        }

        int kMin = findFirstGroupEndingOnOrAfter(zeroGroups, l);
        int kMax = findLastGroupStartingOnOrBefore(zeroGroups, r);

        if (kMin > kMax - 1) {
            ans.add(totalOnesInS);
            continue;
        }

        int maxGain = 0;

        int innerL = kMin + 1;
        int innerR = kMax - 2;
        if (innerL <= innerR) {
            maxGain = Math.max(maxGain, st.query(innerL, innerR));
        }

        maxGain = Math.max(maxGain, getClippedGain(zeroGroups, kMin, l, r));

        if (kMax - 1 >= kMin) {
            maxGain = Math.max(maxGain, getClippedGain(zeroGroups, kMax - 1, l, r));
        }

        ans.add(totalOnesInS + maxGain);
    }

    return ans;
}

private int getClippedGain(List<Group> groups, int k, int l, int r) {
    if (k < 0 || k >= groups.size() - 1) return 0;
    Group gLeft = groups.get(k);
    Group gRight = groups.get(k + 1);

    int leftLen = Math.max(0, gLeft.end - Math.max(gLeft.start, l) + 1);
    int rightLen = Math.max(0, Math.min(gRight.end, r) - gRight.start + 1);

    return leftLen + rightLen;
}

private int findFirstGroupEndingOnOrAfter(List<Group> groups, int pos) {
    int low = 0, high = groups.size() - 1, res = groups.size();
    while (low <= high) {
        int mid = (low + high) / 2;
        if (groups.get(mid).end >= pos) {
            res = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return res;
}

private int findLastGroupStartingOnOrBefore(List<Group> groups, int pos) {
    int low = 0, high = groups.size() - 1, res = -1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (groups.get(mid).start <= pos) {
            res = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return res;
}

void main() {
}