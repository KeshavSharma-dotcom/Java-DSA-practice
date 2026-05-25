// jump game 7

boolean canReach(String s,int minJump,int maxJump){
    int n = s.length();
    boolean[] reachable = new boolean[n];
    reachable[0] = true;

    int maxReachable = 0;

    for (int i = 0; i < n; i++) {
        if (!reachable[i]) {
            continue;
        }

        int start = Math.max(i + minJump, maxReachable + 1);
        int end = Math.min(i + maxJump, n - 1);

        for (int j = start; j <= end; j++) {
            if (s.charAt(j) == '0') {
                reachable[j] = true;
            }
        }

        maxReachable = Math.max(maxReachable, end);
    }

    return reachable[n - 1];
}
void main(){
    String s = "0110110";
    System.out.println(canReach(s,2,3));
}
