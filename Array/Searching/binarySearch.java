void BinarySearch(int[] a ,int target){
    Arrays.sort(a);
    System.out.println(Arrays.toString(a));
    int right = a.length-1;
    int left = 0;
    int mid;
    while(left<=right){
        mid = left+(right-left)/2;
        if(a[mid]==target){
            System.out.println("Target found at "+mid+" index");
            return;
        }
        if(target > a[mid]){
            left = mid+1;
        }else{
            right=mid-1;
        }
    }
}

void main(){
    int[] a = {9,3,7,1,0,5,8,2};
    int target = 8;
    BinarySearch(a,target);
}