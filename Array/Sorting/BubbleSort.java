int[] BubbleSort(int[] arr){
    if(arr.length == 0){
        return arr;
    }
    int k = arr.length;
    for(int i=0;i<arr.length-1;i++){
        boolean swapped = false;
        for(int j=1;j<k;j++){
            if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
            }
        }
        if(!swapped){
            break;
        }
        k--;
    }
    return arr;
}
void main(){
    int[] a = {8,2,88,25,0,2,56,34,76,45,3,0,8,0};
    a = BubbleSort(a);
    System.out.println(Arrays.toString(a));
}