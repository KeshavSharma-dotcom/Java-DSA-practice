static class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
static class LinkedList{
    Node head,tail;
    public void insertElement(int value){
        Node n1 = new Node(value);
        if(head == null){
            head = n1;
            tail = n1;
            return;
        }
        tail.next = n1;
        tail = n1;
    }
    public Node ReverseGroup(Node H){
        if(H ==null || H.next == null){
            return H;
        }
        Node NewHead = ReverseGroup(H.next);
        H.next.next = H;
        H.next = null;
        return NewHead;
    }
    public Node getKth(Node curr,int k){
        while(curr!=null && k>0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
    public void reverseByK(int k){
        if(head == null || head.next == null){
            return;
        }
        Node CurrentGroup = null;
        Node NextGroup;
        Node temp = new Node(0);
        temp.next = head;
        Node prevGroupTail = temp;
        while(true){
            Node K_Node = getKth(prevGroupTail,k);
            if(K_Node == null){
                break;
            }
            NextGroup = K_Node.next;
            CurrentGroup = prevGroupTail.next;
            K_Node.next = null;
            prevGroupTail.next = ReverseGroup(CurrentGroup);
            CurrentGroup.next = NextGroup;
            prevGroupTail = CurrentGroup;
        }
        head = temp.next;// first groups tail
        tail = CurrentGroup;// last groups head

    }
    public void printList(){

        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}

void main() {
    LinkedList l1 = new LinkedList();
    l1.insertElement(10);
    l1.insertElement(20);
    l1.insertElement(30);
    l1.insertElement(40);
    l1.insertElement(50);
    l1.insertElement(60);
    l1.printList();
    l1.reverseByK(2);
    l1.printList();
    System.out.println("New head : "+l1.head.data+" new tail : "+l1.tail.data);
}