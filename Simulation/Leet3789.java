public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
    long total = 0;
    if (need1 == 0 && need2 == 0) {
        return total;
    }

    if (need1 > need2) {
        total += ((long) Math.min(cost1+cost2, costBoth) * need2);
        total += ((long) Math.min(cost1, costBoth) * (need1-need2));
    } else {
        total += ((long) Math.min(cost1+cost2, costBoth) * need1);
        total += ((long) Math.min(cost2, costBoth) * (need2-need1));
    }

    return total;
}

void main() {
    int cost1 = 3;
    int cost2 = 2;
    int costBoth = 1;
    int need1 = 3;
    int need2 = 2;
    System.out.println(minimumCost(cost1,cost2,costBoth,need1,need2));
}