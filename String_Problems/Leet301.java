public List<String> removeInvalidParentheses(String s) {
    int remOpen = 0;
    int remClose = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') {
            remOpen++;
        } else if (c == ')') {
            if (remOpen > 0) {
                remOpen--;
            } else {
                remClose++;
            }
        }
    }

    Set<String> results = new HashSet<>();
    StringBuilder current = new StringBuilder();

    dfs(s, 0, remOpen, remClose, 0, current, results);

    return new ArrayList<>(results);
}

private void dfs(String s, int index, int remOpen, int remClose,
                 int openBalance, StringBuilder current, Set<String> results) {
    if (index == s.length()) {
        if (remOpen == 0 && remClose == 0 && openBalance == 0) {
            results.add(current.toString());
        }
        return;
    }

    char c = s.charAt(index);
    int len = current.length();

    if (c == '(') {
        if (remOpen > 0) {
            dfs(s, index + 1, remOpen - 1, remClose, openBalance, current, results);
        }
        current.append(c);
        dfs(s, index + 1, remOpen, remClose, openBalance + 1, current, results);
        current.setLength(len);
    } else if (c == ')') {
        if (remClose > 0) {
            dfs(s, index + 1, remOpen, remClose - 1, openBalance, current, results);
        }
        if (openBalance > 0) {
            current.append(c);
            dfs(s, index + 1, remOpen, remClose, openBalance - 1, current, results);
            current.setLength(len);
        }
    } else {
        current.append(c);
        dfs(s, index + 1, remOpen, remClose, openBalance, current, results);
        current.setLength(len);
    }
}
void main() {
    String t = "(())))()((()))";
    System.out.println(removeInvalidParentheses(t));
}