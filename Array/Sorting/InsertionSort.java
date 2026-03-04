int[] insertionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int j = i + 1;
        if (arr[j] > arr[i]) {
            continue;
        }
        if (arr[j] < arr[i]) {
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }
    return arr;
}
void main(){
    int[] arr = {9,5,6,3,0,11,1,89,78,2};
    arr = insertionSort(arr);
    System.out.println(Arrays.toString(arr));
}
