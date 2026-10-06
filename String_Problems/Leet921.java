public int minAddToMakeValid(String s) {
    int count = 0;
    int open = 0;
    for(int i=0;i<s.length();i++){
        if(s.charAt(i) == '('){
            open++;
        }else if(open != 0){
            open--;
        }else{
            count++;
        }
    }
    return count+open;
}

void main() {
    System.out.println(minAddToMakeValid("()))(("));
}