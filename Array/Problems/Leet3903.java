public int firstStableIndex(int[] nums, int k) {
    int n = nums.length;
    int ssn = n;
    for(int i=0;i<n;i++){
        int min = nums[i];
        int max = nums[i];
        for(int j=0;j<i;j++){
            max = Math.max(max,nums[j]);
        }
        for(int q=i;q<n;q++){
            min = Math.min(min,nums[q]);
        }
        int instability = max-min;
        if(instability <= k){
            ssn = Math.min(ssn,i);
        }
    }
    if(ssn == n){
        return -1;
    }
    return ssn;
}

void main() {
    int[] s = {5,0,1,4};
    System.out.println(firstStableIndex(s,3));
}