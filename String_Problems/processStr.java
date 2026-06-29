public String processStr(String s) {
    StringBuilder result = new StringBuilder();
    for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
        if(c == '*'){
            if(!result.isEmpty()){
                result.setLength(result.length()-1);
            }
            continue;
        }
        if(c == '#'){
            result.append(result);
            continue;
        }
        if(c == '%'){
            result.reverse();
            continue;
        }
        result.append(c);
    }

    return result.toString();
}


void main(){
    System.out.println(processStr("hello%"));
}


