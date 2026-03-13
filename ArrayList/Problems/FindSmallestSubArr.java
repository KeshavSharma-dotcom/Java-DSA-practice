// Smallest subarray containing all the targeted elements
int findSmallestSubarray(ArrayList<Integer> list,HashSet<Integer> target){
    Map<Integer,Integer> window = new HashMap<>();
    int minLen = Integer.MAX_VALUE;
    int left = 0;
    int satisfyVal = 0;
    for(int right =0;right<list.size();right++){
        int i = list.get(right);
        if(target.contains(i)){

            window.put(i,window.getOrDefault(i,0)+1);
            System.out.println(window);
            if(window.get(i) == 1){
                satisfyVal++;
            }
        }
        while(satisfyVal == target.size()){
            minLen = Math.min(minLen,right-left+1);
            int leftNum = list.get(left);
            if(target.contains(leftNum)){
                window.put(leftNum,window.get(leftNum)-1);
                if(window.get(leftNum) == 0){
                    satisfyVal--;
                }
            }
            left++;
        }
    }
    return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
}


void main(){
    ArrayList<Integer> lst = new ArrayList<>(Arrays.asList(0,1,8,3,9,4,5));
    HashSet<Integer> set = new HashSet<>(Arrays.asList(1,8,9));
    int res = findSmallestSubarray(lst,set);
    System.out.println("Length of Smallest Subarray: "+res);
}