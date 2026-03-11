ArrayList<ArrayList<Integer>> MergeIntervals(ArrayList<ArrayList<Integer>> Intervals){
    if(Intervals.size() <= 1){
        return Intervals;
    }
    ArrayList<ArrayList<Integer>> newList = new ArrayList<>();
    ArrayList<Integer> currInterval = Intervals.getFirst();
    newList.add(currInterval);
    for(int i=1;i<Intervals.size();i++){
        ArrayList<Integer> nextInterval = Intervals.get(i);
        int currEnd = currInterval.get(1);
        if (currEnd >= nextInterval.get(0)) {
            currInterval.set(1,Math.max(currEnd,nextInterval.get(1)));
        }else{
            currInterval = nextInterval;
            newList.add(currInterval);
        }
    }
    return newList;
}

void main(){
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    for(int i=0;i<4;i++){
        ArrayList<Integer> lst = new ArrayList<>();
        for(int j=0;j<2;j++){
            lst.add(sc.nextInt());
        }
        list.add(lst);
    }
    list.sort((a, b) -> Integer.compare(a.getFirst(), b.getFirst()));
    ArrayList<ArrayList<Integer>> result = MergeIntervals(list);
    System.out.println(list);
    System.out.println("Merged Intervals: "+result);
}
