// 5th July

public int[] pathsWithMaxScore(List<String> board) {
    int n = board.toArray().length;
    int mod = 1000000007;
    int[][] dp = new int[n][n];
    int[][] ways = new int[n][n];
    for(int[] s : dp){
        Arrays.fill(s,Integer.MIN_VALUE);
    }
    dp[n-1][n-1] = 0;
    ways[n-1][n-1] = 1;
    for(int row=n-1;row>=0;row--){
        for(int column=n-1;column>=0;column--){
            char cell = board.get(row).charAt(column);
            if(cell == 'X' || (row == n-1 && column == n-1)){
                continue;
            }

            int value = Character.isDigit(cell) ? cell-'0' : 0;
            int maxBelow = row+1 < n ? dp[row+1][column] : Integer.MIN_VALUE;
            int maxRight = column+1 < n ? dp[row][column+1] : Integer.MIN_VALUE;
            int maxDiagonal = row+1 < n && column+1 <n ? dp[row+1][column+1] : Integer.MIN_VALUE;

            int currMax = Math.max(maxBelow,maxRight);
            currMax = Math.max(currMax,maxDiagonal);
            if(currMax == Integer.MIN_VALUE){
                continue;
            }
            dp[row][column] = value + currMax;
            if(maxBelow == currMax){
                ways[row][column] = (ways[row][column] + ways[row+1][column])%mod;
            }
            if(maxRight == currMax){
                ways[row][column] = (ways[row][column] + ways[row][column+1])%mod;
            }
            if(maxDiagonal == currMax){
                ways[row][column] = (ways[row][column] + ways[row+1][column+1])%mod;
            }
        }
    }
    if(dp[0][0] ==  Integer.MIN_VALUE){
        return new int[]{0,0};
    }
    return new int[]{dp[0][0],ways[0][0]};
}

void main() {
    List<String > b = new ArrayList<>();
    b.add("E23");
    b.add("2X2");
    b.add("12S");
    System.out.println(Arrays.toString(pathsWithMaxScore(b)));

}