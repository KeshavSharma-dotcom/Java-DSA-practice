void swap(int[] arr, int num1,int num2){
    int temp = arr[num1];
    arr[num1] = arr[num2];
    arr[num2] = temp;
    System.out.println(arr[num1]+" is swapped with "+arr[num2]);

}
void quickSort(int[] arr,int start,int end){
    if(start >= end){
        return;
    }
    int left = start;
    int right = end;
    int mid = left+(right-left) /2;
    int pivot= arr[mid];

    System.out.println(pivot);
    while(left<right){
        while(arr[left]<pivot){
            left++;
        }
        while(arr[right]>pivot){
            right--;
        }
        if(left<=right){
            swap(arr,left,right);
            left++;
            right--;
        }
    }
    System.out.println(Arrays.toString(arr));
    quickSort(arr, start,right);
    quickSort(arr,left ,end);
}

void main(){
    int[] arr = {5,2,4,3,1};
    quickSort(arr,0,arr.length-1);
}