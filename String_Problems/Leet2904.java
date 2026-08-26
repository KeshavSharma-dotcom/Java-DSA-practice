public String shortestBeautifulSubstring(String s, int k) {
    List<Integer> ls = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '1') {
            ls.add(i);
        }
    }
    if (ls.size() < k) {
        return "";
    }
    String ans = "";
    for (int i = 0; i + k - 1 < ls.size(); i++) {
        int start = ls.get(i);
        int end = ls.get(i + k - 1);
        String sub = s.substring(start, end + 1);

        if (ans.isEmpty() || sub.length() < ans.length() ||
                (sub.length() == ans.length() && sub.compareTo(ans) < 0)) {
            ans = sub;
        }
    }

    return ans;
}

void main() {
}