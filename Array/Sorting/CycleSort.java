int[] cycleSort(int[] a){
    int i =0;
    while(i<a.length){
        int corrIndex = a[i]-1;

        if(a[i] != a[corrIndex]){
            int temp = a[i];
            a[i] = a[corrIndex];
            a[corrIndex] = temp;
        }else{
            i++;
        }
    }
    return a;
}

void main(){
    int[] arr = {4,5,1,3,2};
    arr = cycleSort(arr);
    System.out.println(Arrays.toString(arr));
}
