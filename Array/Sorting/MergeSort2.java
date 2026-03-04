//Using Raw Pattern
int[] Merge(int[] first,int[] second){
    int[] NewArr = new int[first.length+ second.length];
    int i =0;
    int j=0;
    int k =0;
    while(i<first.length && j<second.length){
        if(first[i]<second[j]){
            NewArr[k] = first[i];
            i++;
        }else{
            NewArr[k] = second[j];
            j++;
        }
        k++;
    }
    while(i<first.length){
        NewArr[k] = first[i];
        i++;
        k++;
    }
    while(j<second.length){
        NewArr[k] = second[j];
        j++;
        k++;
    }
    return NewArr;
}
int[] MergeSort(int[] arr){
//    Faults i made :
//    recursion ending condition : arr.length == 0;
//    over engineering trap : checking mid == 1 even though the while loops can easily fix them
//    j starting with : arr.length - mid -1;
    if(arr.length <= 1){
        return arr;
    }
    int mid = arr.length/2;
    int[] first = new int[mid];
    int i =0;

    int[] second = new int[arr.length-mid];
    int j =mid;
    int k =0;
    while(i<mid){
        first[i] = arr[i];
        i++;
    }
    while(j<arr.length){
        second[k] = arr[j];
        j++;
        k++;
    }
    System.out.println(Arrays.toString(first)+" "+Arrays.toString(second));
    int[] left = MergeSort(first);
    int[] right = MergeSort(second);
    return Merge(left,right);
}

void main(){
    int[] arr = {5,2,4,3,1};
    arr= MergeSort(arr);
    System.out.println(Arrays.toString(arr));
}

