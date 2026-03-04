void linearSearch(int[] a, int target){
    for(int i=0;i<target;i++){
        if(a[i] == target){
            System.out.println("got " + target +" at "+ i + " index" );
            return;
        }
    }
}
void main(){
    int[] arr = {8,2,7,8,5,6,0,1};
    linearSearch(arr,5);
}