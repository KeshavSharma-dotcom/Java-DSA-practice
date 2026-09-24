public int smallestIndex(int[] nums){
    int currentSummedIdx = 101;
    for(int num = 0;num < nums.length;num++){
        int prodSum = 0;
        int currentInt = nums[num];
        while(currentInt > 0){
            prodSum += (currentInt % 10);
            if(prodSum > num){
                break;
            }
            currentInt /= 10;
        }
        if(prodSum == num){
            return Math.min(currentSummedIdx,prodSum);
        }
    }
    return -1;
}

void main() {
    int[] n = {1,10,11};
    System.out.println(smallestIndex(n));
}
