public String evaluate(String s, List<List<String>> knowledge) {
    Map<String, String> map = new HashMap<>();
    for (List<String> entry : knowledge) {
        map.put(entry.get(0), entry.get(1));
    }

    StringBuilder result = new StringBuilder();
    StringBuilder key = new StringBuilder();
    boolean inside = false;

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        if (ch == '(') {
            inside = true;
            key.setLength(0);
        } else if (ch == ')') {
            inside = false;
            result.append(map.getOrDefault(key.toString(), "?"));
        } else if (inside) {
            key.append(ch);
        } else {
            result.append(ch);
        }
    }

    return result.toString();
}

void main() {
}