void RemoveDuplicates(ArrayList<Integer> list){
    ArrayList<Integer> newList = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    int i = 0;
    while(list.size()>i){
        int curr = list.get(i);
        if(set.add(curr)){
            newList.add(curr);
        }else{
            i++;
        }
    }
    System.out.println();
    System.out.println("Unique Elements: "+newList);
}


void main(){
    ArrayList<Integer> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    for(int i=0;i<5;i++){
        list.add(sc.nextInt());
    }
    System.out.println();
    System.out.println("Original: "+list);
    RemoveDuplicates(list);
}