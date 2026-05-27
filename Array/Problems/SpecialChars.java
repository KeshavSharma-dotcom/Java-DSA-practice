public int numberOfSpecialChars(String word) {
    int n = word.length(),v=0;
    HashSet<Character> s = new HashSet<>();
    HashSet<Character> s2 = new HashSet<>();
    for(int i=0;i<n;i++){
        char c = word.charAt(i);
        s.add(c);
        if(Character.isUpperCase(c) && s.contains(Character.toLowerCase(c))){
            s2.add(Character.toLowerCase(c));
        }
        if(Character.isLowerCase(c) && s.contains(Character.toUpperCase(c))){
            s2.add(c);
        }
    }
    System.out.println(s2);
    return s2.size();
}
void main(){
    String s = "";
    System.out.println(numberOfSpecialChars(s));
}