public boolean canAliceWin(int n) {
    boolean s = false;
    for(int i=10;i>0;i--){
        n-=i;
        if(n<0){
            return s;
        }
        s = !s;
    }
    return s;
}

void main() {
    System.out.println(canAliceWin(50));
}