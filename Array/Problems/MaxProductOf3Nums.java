public int maximumProduct(int[] nums) {
    int max = Integer.MIN_VALUE, max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE,min1 = Integer.MAX_VALUE;
    for(int i : nums){
        if(i >= max){
            max2 = max1;
            max1 = max;
            max = i;
        }else if(i >= max1){
            max2 = max1;
            max1 = i;
        }else if(i >= max2){
            max2 = i;
        }

        if(i <= min){
            min1 = min;
            min = i;
        }else if(i <= min1){
            min1 = i;
        }
    }
    return Math.max(max*max1*max2,max*min*min1);
}

void main() {
}