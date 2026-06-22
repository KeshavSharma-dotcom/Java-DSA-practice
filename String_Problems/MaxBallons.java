public int maxNumberOfBalloons(String text) {
    int[] charCounts = new int[26];
    for (int i = 0; i < text.length(); i++) {
        charCounts[text.charAt(i) - 'a']++;
    }

    int bCount = charCounts['b' - 'a'];
    int aCount = charCounts['a' - 'a'];
    int lCount = charCounts['l' - 'a'];
    int oCount = charCounts['o' - 'a'];
    int nCount = charCounts['n' - 'a'];

    int maxBalloons = Math.min(bCount, aCount);
    maxBalloons = Math.min(maxBalloons, lCount / 2);
    maxBalloons = Math.min(maxBalloons, oCount / 2);
    maxBalloons = Math.min(maxBalloons, nCount);

    return maxBalloons;
}

void main() {
    String s = "loonbalxballpoon";
    System.out.println(maxNumberOfBalloons(s));
}