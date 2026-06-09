// JumpGame 3 : Can we reach 0 with jumping forward and backward
boolean[] visited;
boolean canReach(int[] arr, int start){
    if (visited == null) {
        visited = new boolean[arr.length];
    }
    if (start < 0 || start >= arr.length) {
        return false;
    }
    if (visited[start]) {
        return false;
    }
    if (arr[start] == 0) {
        return true;
    }
    visited[start] = true;

    int forward = start + arr[start];
    int backward = start - arr[start];

    return canReach(arr, forward) || canReach(arr, backward);
}
void main(){
    int[] a = {4,2,3,0,3,1,2};
    System.out.println("Jumping result : "+canReach(a,5));
}