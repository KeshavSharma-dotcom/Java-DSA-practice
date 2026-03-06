void quickSort(int[] arr,int start,int end){
    if(start >= end){
        return;
    }
    int left = start;
    int right = end;
    int mid = left+(right-left) /2;
    int pivot= arr[mid];
    System.out.println("Arrays starts from "+left+" to "+"right "+right);
    System.out.println("Current pivot: "+pivot);

    while(left<=right){
        while(arr[left]<pivot){
            left++;
        }
        while(arr[right]>pivot){
            right--;
        }
        if(left<=right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    System.out.println(Arrays.toString(arr));
    quickSort(arr, start,right);
    quickSort(arr,left ,end);
}

void main(){
    int[] arr = {5,2,4,3,1,2,2};
    quickSort(arr,0,arr.length-1);
}