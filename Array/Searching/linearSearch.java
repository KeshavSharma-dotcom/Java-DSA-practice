void linearSearch(int[] a){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter target: ");
    int target = sc.nextInt();
    for(int i=0;i<a.length;i++){
        if(a[i] == target){
            System.out.println("got " + target +" at "+ i + " index" );
            return;
        }
    }
    System.out.println("Target didn't found.");
}
void main(){
    int[] arr = {8,2,7,8,5,6,0,1};
    linearSearch(arr);
}