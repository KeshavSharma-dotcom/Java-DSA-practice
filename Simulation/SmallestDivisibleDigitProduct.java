public int smallestNumber(int n, int t) {
    int q = n;
    while(true){
        if(product(q)%t == 0){
            return q;
        }
        q++;
    }
}
public int product(int i){
    int p = 1;
    while(i > 0){
        p *= (i % 10);
        i /= 10;
    }
    return p;
}

void main() {
    System.out.println(smallestNumber(15,3));
}