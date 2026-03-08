// Calculate median of two sorted arrays
double findMedian(int[] num1,int[] num2){
    int n = num1.length;
    int m = num2.length;
    int totalLen = n+m;
    int p1 = 0;
    int p2 = 0;
    int current = 0;
    int previous=0;
    for(int i=0;i<=totalLen/2;i++){
        previous = current;
        if(p1<n && (p2>=m || num1[p1] <= num2[p2])){
            current = num1[p1];
            p1++;
        }else{
            current = num2[p2];
            p2++;
        }
        System.out.println(previous +" "+current);
    }
    if(totalLen%2 == 0){
        return (double) (current+previous)/2.0;
    }else{
        return current;
    }
}
void main(){
    int[] arr1 = {1,2};
    int[] arr2 = {8,9,10,11};
    double res = findMedian(arr1,arr2);
    System.out.println(res);
}