public int missingMultiple(int[] nums, int k) {
    for(int m=k;;m+=k){
        boolean f = true;
        for(int num : nums){
            if(num % m == 0){
                f = false;
                break;
            }
        }
        if(!f){
            return m;
        }
    }
}

void main() {
    int[] n = {1,4,7,10,15};
    System.out.println(missingMultiple(n,5));
}