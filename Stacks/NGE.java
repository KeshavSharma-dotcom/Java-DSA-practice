int[] NGE(int[] a){
    if(a.length <= 1){
        return a;
    }
    int[] result = new int[a.length];
    Stack<Integer> nextGreater = new Stack<>();
    for(int i=a.length-1;i>=0;i--){
        while(!(nextGreater.isEmpty())&&nextGreater.peek()<=a[i]){
            nextGreater.pop();
        }
        if(nextGreater.isEmpty()){
            result[i] = -1;
        }else{
            result[i] = nextGreater.peek();
        }
        nextGreater.push(a[i]);
    }
    return result;
}
void main(){
    int[] a = {3,4,2,8,2,6,3,0};
    int[] nextGreater = NGE(a);
    System.out.println(Arrays.toString(nextGreater));
}