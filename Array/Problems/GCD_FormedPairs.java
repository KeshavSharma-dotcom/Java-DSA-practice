public int gcd(int a,int b){
    if(b==0){
        return a;
    }
    return gcd(b,a%b);
}
public long gcdSum(int[] nums) {
    int n = nums.length , mx = Integer.MIN_VALUE;
    if(n == 1){
        return 0;
    }
    int[] pg = new int[n];
    for(int i=0;i<n;i++){
        mx = Math.max(mx,nums[i]);
        pg[i] = gcd(nums[i],mx);
    }
    int i=0;
    int j=n-1;
    long a = 0;
    Arrays.sort(pg);
    while(i < j){
        a += gcd(pg[i], pg[j]);
        i++;
        j--;
    }
    return a;
}

void main() {
    int[] a = {3,6,2,8};
    System.out.println(gcdSum(a));
}