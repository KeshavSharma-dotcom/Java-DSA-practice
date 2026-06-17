public int minJumps(int[] arr) {

    int n = arr.length;

    if (n <= 1) {
        return 0;
    }
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    for (int i = 0; i < n; i++) {

        if (!map.containsKey(arr[i])) {
            map.put(arr[i], new ArrayList<>());
        }

        map.get(arr[i]).add(i);
    }

    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[n];

    q.offer(0);
    visited[0] = true;

    int steps = 0;

    while (!q.isEmpty()) {

        int size = q.size();

        for (int i = 0; i < size; i++) {

            int curr = q.poll();

            if (curr == n - 1) {
                return steps;
            }

            List<Integer> neighbors = map.get(arr[curr]);

            if (neighbors != null) {

                for (int next : neighbors) {

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
                map.remove(arr[curr]);
            }
            if (curr + 1 < n && !visited[curr + 1]) {

                visited[curr + 1] = true;
                q.offer(curr + 1);
            }

            if (curr - 1 >= 0 && !visited[curr - 1]) {

                visited[curr - 1] = true;
                q.offer(curr - 1);
            }
        }
        steps++;
    }

    return -1;
}
void main(){
    int[] test = {};
    System.out.println(minJumps(test));
}