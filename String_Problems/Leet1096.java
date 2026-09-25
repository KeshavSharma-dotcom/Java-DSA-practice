private int idx = 0;

public List<String> braceExpansionII(String expression) {
    idx = 0;
    Set<String> set = parseUnion(expression);
    List<String> result = new ArrayList<>(set);
    Collections.sort(result);
    return result;
}

private Set<String> parseUnion(String s) {
    Set<String> res = new HashSet<>();

    while (idx < s.length() && s.charAt(idx) != '}') {
        Set<String> term = parseConcat(s);
        res.addAll(term);

        if (idx < s.length() && s.charAt(idx) == ',') {
            idx++;
        }
    }

    return res;
}

private Set<String> parseConcat(String s) {
    Set<String> res = new HashSet<>();
    res.add("");

    while (idx < s.length() && s.charAt(idx) != ',' && s.charAt(idx) != '}') {
        Set<String> factor = parseFactor(s);
        res = multiply(res, factor);
    }

    return res;
}

private Set<String> parseFactor(String s) {
    Set<String> factor = new HashSet<>();

    if (s.charAt(idx) == '{') {
        idx++;
        factor = parseUnion(s);
        idx++;
    } else {
        factor.add(String.valueOf(s.charAt(idx)));
        idx++;
    }

    return factor;
}

private Set<String> multiply(Set<String> set1, Set<String> set2) {
    Set<String> product = new HashSet<>();
    for (String s1 : set1) {
        for (String s2 : set2) {
            product.add(s1 + s2);
        }
    }
    return product;
}

void main() {
}