public int minOperations(int[] nums,int x){
    int totalSum = 0;
    int n = nums.length;
    for(int num : nums){
        totalSum += num;
    }
    int target = totalSum - x;
    if(target == 0) return n;
    int maxLen = -1;
    int currentSum = 0,l = 0;
    for(int r = 0; r <n; r++){
        currentSum += nums[r];
        while(l <= r && currentSum > target){
            currentSum -= nums[l];
            l++;
        }
        if(currentSum == target){
            maxLen = Math.max(maxLen,r-l+1);
        }
    }
    return maxLen==-1 ? -1 : n - maxLen;
}

void main() {
    int[] nums = {1,1,4,2,3};
    System.out.println(minOperations(nums,5));
}