//1. remove duplicate and create new list with only unique elements
//2. rotate k elements from right

void main(){
    ArrayList<Integer> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    for(int i=0;i<5;i++){
        list.add(sc.nextInt());
    }
    System.out.println(list);
//    1.
    ArrayList<Integer> newList = new ArrayList<>();
    int i = 0;
    int k = 0;
    while(list.size()>i){
        int current = list.get(i);
        if(newList.contains(current)){
            i++;
        }else{
            newList.add(k,current);
            k++;
        }
    }
    System.out.println(newList);
//    2.
    System.out.println("Enter number from where the list rotates from right to left : ");
    int kr = sc.nextInt();
    int indexE = list.size()-1;
    int j =0;
    while(kr>0){
        int curr = list.get(j);
        int chan = list.get(indexE);
        list.set(j,chan);
        list.set(indexE,curr);
        j++;
        indexE--;
        kr--;
    }
    System.out.println(list);
}