int findMin(int[] nums){
    if(nums.length==1){
        return nums[0];
    }
    int left = 0;
    int right = nums.length-1;
    int mid;
    while(left<right){
        mid = left+(right-left)/2;
        if(nums[mid] < nums[right]){
            right = mid;
        }else {
            left = mid+1;
        }
    }
    return nums[left];
}
void main(){
    int[] nums = {7,8,9,10,0,2,3,4,5,6};
    System.out.println(findMin(nums));
}