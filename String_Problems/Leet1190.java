public String reverseParentheses(String s) {
    int n = s.length();
    int[] pair = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
        char c = s.charAt(i);
        if (c == '(') {
            stack.push(i);
        } else if (c == ')') {
            int open = stack.pop();
            pair[open] = i;
            pair[i] = open;
        }
    }

    StringBuilder sb = new StringBuilder();
    int i = 0;
    int step = 1;

    while (i < n) {
        char c = s.charAt(i);
        if (c == '(' || c == ')') {
            i = pair[i];
            step = -step;
        } else {
            sb.append(c);
        }
        i += step;
    }

    return sb.toString();
}

void main() {
}