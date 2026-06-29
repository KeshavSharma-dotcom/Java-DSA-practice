public char processStr(String s, long k) {
    char ans = '.';
    long curr=0;
    long[] lengths = new long[s.length()];
    for(int i=0;i<s.length();i++) {
        char c = s.charAt(i);
        if (c == '*') {
            curr = Math.max(0, curr - 1);
        } else if (c == '#') {
            curr = curr * 2;
        } else if(c == '%'){

        }else{
            curr++;
        }
        lengths[i] = curr;
    }
    if(k < 0 || lengths[lengths.length-1] <= k){
        return ans;
    }
    for (int i= s.length()-1;i>=0;i--){
        char c = s.charAt(i);
        if (c == '#') {
            k %= lengths[i-1];
        } else if(c == '%'){
            k = (lengths[i]-1)-k ;
        }else if(c == '*'){
            continue;
        }else{
            if(k == lengths[i]-1){
                return s.charAt(i);
            }else{
                lengths[i]--;
            }
        }
    }
    return s.charAt((int)k);
}

void main() {
    System.out.println(processStr("H*llo#",2));
}