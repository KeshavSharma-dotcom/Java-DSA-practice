public int minimumCost(int[] cost) {
    Arrays.sort(cost);
    int n=cost.length-1;
    int sum=0,v=0;
    while(n>=0){
        if(v==2){
            v=0;
        }else{
            sum += cost[n];
            v++;
        }
        n--;
    }
    return sum;
}

void main() {
    int[] a = {2,2,2,2};
    System.out.println(minimumCost(a));
}