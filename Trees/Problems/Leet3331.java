private List<Integer>[] origAdj;
private List<Integer>[] newAdj;
private int[] newParent;
private int[] lastSeen;
private int[] subtreeSize;
private String s;

@SuppressWarnings("unchecked")
public int[] findSubtreeSizes(int[] parent, String s) {
    int n = parent.length;
    this.s = s;

    origAdj = new ArrayList[n];
    newAdj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        origAdj[i] = new ArrayList<>();
        newAdj[i] = new ArrayList<>();
    }

    // 1. Build original tree adjacency list
    for (int i = 1; i < n; i++) {
        origAdj[parent[i]].add(i);
    }

    // 2. Find new parents simultaneously using DFS + backtracking
    newParent = Arrays.copyOf(parent, n);
    lastSeen = new int[26];
    Arrays.fill(lastSeen, -1);

    findNewParents(0);

    // 3. Build the modified tree
    for (int i = 1; i < n; i++) {
        newAdj[newParent[i]].add(i);
    }

    // 4. Compute final subtree sizes
    subtreeSize = new int[n];
    computeSizes(0);

    return subtreeSize;
}

private void findNewParents(int u) {
    int charIdx = s.charAt(u) - 'a';
    int prevAncestor = lastSeen[charIdx];

    // If an ancestor with the same character exists on the current path, update parent
    if (prevAncestor != -1) {
        newParent[u] = prevAncestor;
    }

    // Mark current node as the closest ancestor for this character
    lastSeen[charIdx] = u;

    for (int v : origAdj[u]) {
        findNewParents(v);
    }

    // Backtrack: restore the ancestor state before returning to parent
    lastSeen[charIdx] = prevAncestor;
}

private int computeSizes(int u) {
    int size = 1;
    for (int v : newAdj[u]) {
        size += computeSizes(v);
    }
    subtreeSize[u] = size;
    return size;
}
void main(){
    int[] t = {-1,0,0,1,1,1};
    System.out.println(Arrays.toString(findSubtreeSizes(t,"abaabc")));
}