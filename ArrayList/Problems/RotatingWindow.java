void reverse(ArrayList<Integer> list,int start, int end){
    while(start<end){
        int curr = list.get(start);
        list.set(start,list.get(end));
        list.set(end,curr);
        start++;
        end--;
    }
}

void main() {
    ArrayList<Integer> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    for(int i=0;i<5;i++){
        list.add(sc.nextInt());
    }

    System.out.println("Before Rotation: "+list);
    System.out.println("Enter number from where the list rotates from right to left : ");
    int kr = sc.nextInt();
    reverse(list,0,list.size()-1);
    reverse(list,0,kr-1);
    reverse(list,kr,list.size()-1);
    System.out.println("After Rotation: "+list);
}
