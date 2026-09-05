public int firstStableIndex(int[] nums, int k) {
    int n = nums.length;
    int[] suffMin = new int[n];
    suffMin[n-1] = nums[n-1];
    for(int i=n-2;i>=0;i--){
        suffMin[i] = Math.min(nums[i],suffMin[i+1]);
    }
    int prev = nums[0];
    for(int i=0;i<n;i++){
        prev = Math.max(prev, nums[i]);
        if(prev - suffMin[i] <= k){
            return i;
        }
    }
    return -1;
}

void main() {
    int[] s = {5,0,1,4};
    System.out.println(firstStableIndex(s,3));
}