public int sumCounts(List<Integer> nums) {
    int slidingWindowLen = 1;
    List<Integer> ls = new ArrayList<>();
    int sum = 0;
    while (slidingWindowLen <= nums.size()){
        for (int i=0;i<nums.size();i++){
            for (int j=i;j<slidingWindowLen;j++){
                if(!ls.contains(nums.get(j))){
                    ls.add(nums.get(j));
                }
            }
            sum += (ls.size()*ls.size());
            ls.clear();
        }
        slidingWindowLen++;
    }
    return sum;
}

void main() {
    List<Integer> ls = new ArrayList<>();
    ls.add(1);
    ls.add(2);
    ls.add(1);
    System.out.println(sumCounts(ls));
}