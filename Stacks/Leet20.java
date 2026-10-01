public boolean isValid(String s){
    Deque<Character> stack = new ArrayDeque<>();
    if(s.length() % 2 != 0){
        return false;
    }
    for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
        if(!stack.isEmpty() && (c==')' || c==']'|| c=='}')) {
            char open = stack.pop();
            if((open == '(' && c ==')') || (open == '[' && c ==']') || (open == '{' && c =='}')){
                continue;
            }else{
                return false;
            }
        }
        stack.push(c);
    }
    return stack.isEmpty();
}

void main() {
    System.out.println(isValid("{{}}"));
}