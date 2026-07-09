public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
    int[] g = new int[n];
    for(int i=0;i<n-1;i++){
        if(nums[i+1] - nums[i] <=maxDiff){
            g[i] = 1;
        }
    }
    int[] prefixSum = new int[n];
    for(int i=1;i<n;i++){
        prefixSum[i] = prefixSum[i-1] + g[i-1] ;
    }
    boolean[] answer = new boolean[queries.length];
    for(int i=0;i< queries.length;i++){
        int s = queries[i][0];
        int e = queries[i][1];
        int temp = Math.max(e,s) - Math.min(e,s);
        int ex = prefixSum[e] - prefixSum[s];
        answer[i] = (temp == ex);
    }
    return answer;
}

void main() {
}