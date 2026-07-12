public int[] arrayRankTransform(int[] arr) {
    if(arr.length == 0){
        return new int[]{};
    }
    int n = arr.length,k=2,i=1;
    int[] arr2 = Arrays.copyOf(arr,n);
    Arrays.sort(arr2);
    HashMap<Integer,Integer> map=new HashMap<>();
    map.put(arr2[0],1);
    while(i < arr2.length){
        if(!(arr2[i-1] == arr2[i])){
            map.put(arr2[i],k);
            k++;
        }
        i++;
    }
    for(int b=0;b<arr.length;b++){
        int w = map.get(arr[b]);
        arr[b] = w;
    }
    return arr;
}

void main() {
    int[] a = {-37,12,28,9,100,56,80,5,-12};
    System.out.println(Arrays.toString(arrayRankTransform(a)));
}