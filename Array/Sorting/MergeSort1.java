//Merge sort using copyOfRange() function
int[] merge(int[] leftArr, int[] rightArr) {
    int[] newArr = new int[leftArr.length+ rightArr.length];
    int i =0;
    int j=0;
    int k=0;
    while(i<leftArr.length && j<rightArr.length){
        if(leftArr[i] < rightArr[j]){
            newArr[k] = leftArr[i];
            i++;

        }else{
            newArr[k] = rightArr[j];
            j++;
        }
        k++;
    }
    while(i< leftArr.length){
        newArr[k] = leftArr[i];
        i++;
        k++;
    }
    while(j < rightArr.length){
        newArr[k] = rightArr[j];
        j++;
        k++;
    }

    return newArr;
}

int[] mergeSort(int[] arr){
    if(arr.length == 1){
        return arr;
    }
    int mid = arr.length/2;
    int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
    int[] rightArr = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

    return merge(leftArr,rightArr);
}

void main(){
    int[] arr = {5,2,4,3,1};
    arr= mergeSort(arr);
    System.out.println(Arrays.toString(arr));
}