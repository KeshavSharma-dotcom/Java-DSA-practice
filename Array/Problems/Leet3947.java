public int maximumSaleItems(int[][] items, int budget) {
    int n = items.length;
    int[] freq = new int[n + 1];
    for (int[] item : items) {
        freq[item[0]]++;
    }

    int[] divCount = new int[n + 1];
    for (int v = 1; v <= n; v++) {
        if (freq[v] == 0) continue;
        for (int multiple = v; multiple <= n; multiple += v) {
            divCount[v] += freq[multiple];
        }
    }

    long[][] itemData = new long[n][2];
    for (int i = 0; i < n; i++) {
        itemData[i][0] = items[i][1];
        itemData[i][1] = divCount[items[i][0]] - 1;
    }

    Arrays.sort(itemData, (a, b) -> Long.compare(a[0], b[0]));

    long pMin = itemData[0][0];
    long remBudget = budget;
    long totalItems = 0;

    for (int i = 0; i < n; i++) {
        long price = itemData[i][0];
        long cap = itemData[i][1];

        if (cap == 0) continue;

        if (price >= 2 * pMin) {
            break;
        }

        long maxCanBuy = remBudget / price;
        if (maxCanBuy >= cap) {
            remBudget -= cap * price;
            totalItems += 2 * cap;
        } else {
            long optA = totalItems + 2 * maxCanBuy + (remBudget - maxCanBuy * price) / pMin;

            long optB = 0;
            if (maxCanBuy >= 1) {
                long bought = maxCanBuy - 1;
                optB = totalItems + 2 * bought + (remBudget - bought * price) / pMin;
            }

            return (int) Math.max(optA, optB);
        }
    }

    totalItems += remBudget / pMin;
    return (int) totalItems;
}

void main() {
}