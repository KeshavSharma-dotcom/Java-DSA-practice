static class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
static class SinglyLL{
    Node head,tail;
    public void insert(int val){
        Node n = new Node(val);
        if(head == null){
            head = n;
            tail = n;
            return;
        }
        tail.next = n;
        tail = n;
    }
    public void reverse(){
        if(head == null) return;
        tail = head;
        head = reverseSLL(head);
    }
    public Node reverseSLL(Node H){
        if(H == null || H.next == null){
            return H;
        }
        Node NewH = reverseSLL(H.next);
        H.next.next = H;
        H.next = null;
        return NewH;
    }
    public void print(){
        if(head == null) {
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
void main(){
    SinglyLL l = new SinglyLL();
    l.insert(10);
    l.insert(90);
    l.insert(50);
    l.insert(20);
    l.insert(70);
    l.insert(40);
    l.insert(80);
    l.print();
    l.reverse();
    System.out.print("After reversing : ");
    l.print();
}