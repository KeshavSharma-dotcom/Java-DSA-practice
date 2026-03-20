static class Node {
    int data;
    Node next;
    Node (int data){
        this.data = data;
        this.next = null;
    }
}
static class LL{
    Node head,tail;
    public void insert(int val) {
        Node n = new Node(val);
        if(head == null){
            head = n;
            tail = n;
            return;
        }
        tail.next = n;
        tail = n;
    }

    public void printList(){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public LL mergeSortedLL(LL l1, LL l2){
        if(l2.head == null){
            return l1;
        }
        if(l1.head == null){
            return l2;
        }
        LL newList = new LL();
        Node temp1 = l1.head;
        Node temp2 = l2.head;
        Node temp = new Node(0);
        Node curr = temp;
        while(temp1 != null && temp2 != null){
            if(temp1.data >= temp2.data){
                curr.next = temp2;
                temp2 = temp2.next;
            }else{
                curr.next = temp1;
                temp1 = temp1.next;
            }
            curr = curr.next;
        }
        if(temp1 != null){
            curr.next = temp1;
        }else{
            curr.next = temp2;
        }

        newList.head = temp.next;
        Node tailFinder = newList.head;

        while(tailFinder.next != null) tailFinder = tailFinder.next;
        newList.tail = tailFinder;

        return newList;
    }
}
void main(){
    LL l = new LL();
    l.insert(10);
    l.insert(20);
    l.insert(30);
    l.insert(40);
    l.insert(50);
    l.printList();
    LL l2 = new LL();
    l2.insert(10);
    l2.insert(20);
    l2.insert(20);
    LL sorted = new LL();
    sorted = sorted.mergeSortedLL(l,l2);
    sorted.printList();
}