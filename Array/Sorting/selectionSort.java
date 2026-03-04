int getMinIndex(int[] arr, int start , int end){
    int min = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
    return min;
}
void main()
{
    int[] a = {9,11,0,1,7,5,3,6,8};

    for(int o=0;o<a.length;o++) {

        int minIndex = getMinIndex(a, o, a.length-1);
        System.out.println("minimum is "+a[minIndex]);

        int tem = a[o];
        a[o] = a[minIndex];
        a[minIndex] = tem;

        System.out.println(Arrays.toString(a));
    }
}