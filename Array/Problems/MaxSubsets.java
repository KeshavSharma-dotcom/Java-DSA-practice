public int maximumLength(int[] nums) {
    int maxSubset = 1;
    HashMap<Integer,Integer> map = new HashMap<>();
    Set<Integer> s = new HashSet<>();
    for(int i : nums){
        map.put(i, map.getOrDefault(i, 0) + 1);
    }
    if(map.containsKey(1)){
        int count1 = map.get(1);
        maxSubset = Math.max(maxSubset,(count1 % 2)==0 ? count1-1 : count1);
    }

    for(int x : map.keySet()){
        if(x == 1 || s.contains(x)){
            continue;
        }
        int Len = 0;
        long curr = x;

        while(map.containsKey((int)curr) && map.get((int)curr) >= 2 ){
            Len += 2;
            s.add((int)curr);
            curr *= curr;
            if(curr > 1000000000){
                break;
            }
        }
        if(curr <= 1000000000 && map.containsKey((int) curr) && map.get((int)curr)>=1){
            Len++;
        }else{
            Len--;
        }
        maxSubset = Math.max(maxSubset,Len);
    }
    return maxSubset;
}

void main() {
    int[] a = {5,4,1,2,2};
    System.out.println(maximumLength(a));
}