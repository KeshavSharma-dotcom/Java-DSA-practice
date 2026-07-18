public int findGCD(int a,int b){
    if(b==0){
        return a;
    }
    return findGCD(b,a%b);
}
public int gcdOfOddEvenSums(int n) {
    int evenSum = 0;
    int oddSum = -1;
    int to = 0,te = 0;
    for(int i=0;i<n;i++){
        evenSum += 2;
        oddSum += 2;
        to+=oddSum;
        te+=evenSum;
    }
    System.out.println(oddSum+ " " +evenSum);
    return findGCD(to,te);
}

void main() {
    System.out.println(gcdOfOddEvenSums(1));
}