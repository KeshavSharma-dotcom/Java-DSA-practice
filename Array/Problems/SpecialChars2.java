// special chars 2

public int numberOfSpecialChars(String word) {
    int v = 0;
    int[] lastLower = new int[26];
    int[] firstUpper = new int[26];
    Arrays.fill(lastLower,-1);
    Arrays.fill(firstUpper,-1);
    for (int idx = 0; idx < word.length(); idx++) {
        char c = word.charAt(idx);

        if (c >= 'a' && c <= 'z') {
            int arrayIdx = c - 'a';
            lastLower[arrayIdx] = idx;

        } else if (c >= 'A' && c <= 'Z') {
            int arrayIdx = c - 'A';
            if (firstUpper[arrayIdx] == -1) {
                firstUpper[arrayIdx] = idx;
            }
        }
    }
    for (char i = 'a';i<='z';i++){
        int c = i - 'a';
//        lli = last lower index , fui = first upper index
        int lli = lastLower[c];
        int fui = firstUpper[c];
        if(lli != -1 && fui != -1 && lli < fui){
            v++;
        }
    }
    return v;
}
void main(){
    System.out.println(numberOfSpecialChars("aAaB"));
}