boolean validParentheses(String s) {
    if (s.length() <= 1 || s.length() % 2 != 0) {
        return false;
    }
    Stack<Character> stack = new Stack<>();
    int i = 0;
    while (s.length() > i) {
        if (s.charAt(i) == '(') {
            stack.push(')');
        } else if (s.charAt(i) == '[') {
            stack.push(']');
        } else if (s.charAt(i) == '{') {
            stack.push('}');
        } else if(stack.isEmpty() || stack.pop() != s.charAt(i)) {
            return false;
        }
        i++;
    }
    return stack.isEmpty();
}
void main(){
    String s = "({[()]})";
    System.out.println("String has valid parenthesis : "+validParentheses(s));
}