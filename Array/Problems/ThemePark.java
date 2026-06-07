public int earliestFinishTime(int[] lSt, int[] lD, int[] wSt, int[] wD) {
    int q=wSt.length;
    int[][] p = new int[q][2];
    for(int k=0;k<q;k++){
        p[k][0] = wSt[k];
        p[k][1] = wD[k];
    }
    Arrays.sort(p, Comparator.comparingInt(a -> a[0]));
    int[] preMin = new int[q];
    int[] sufMin = new int[q];
    preMin[0] = p[0][1];
    sufMin[q-1] = p[q-1][0] + p[q-1][1];
    for(int k=1;k<q;k++){
        preMin[k] = Math.min(preMin[k-1],p[k][1]);
    }
    for(int k=q-2;k>=0;k--){
        sufMin[k] = Math.min(sufMin[k+1],p[k][0] + p[k][1]);
    }
    int min = 0;
    for(int i=0;i<lSt.length;i++){
        int target = lSt[i] + lD[i];
        int left=0,right=p.length-1,minIdx=-1;

        while(left<=right) {
            int mid = left +( right - left )/2;
            if(p[mid][0]<=target){
                minIdx = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        min = Math.min(preMin[minIdx],sufMin[minIdx]);
    }
    return min;
}

void main() {
    int[] a = {0,7};
    int[] s = {35,7};
    int[] d = {4};
    int[] f = {41};
    System.out.println(earliestFinishTime(a,s,d,f));
}