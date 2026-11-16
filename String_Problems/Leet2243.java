public String digitSumAndString(String s){
    int sum = 0;
    for(int i=0;i<s.length();i++){
        sum += (s.charAt(i)-'0');
    }
    return "" + sum;
}
public String digitSum(String s,int k){
    while(s.length() > k){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i+=(k)){
            String g;
            if(i+k < s.length()){
                g = s.substring(i,i+k);
            }else{
                g = s.substring(i);
            }
            res.append(digitSumAndString(g));
        }
        s = res.toString();
    }
    return s;
}
void main(){
    System.out.println(digitSum("11111222223",3));
}
