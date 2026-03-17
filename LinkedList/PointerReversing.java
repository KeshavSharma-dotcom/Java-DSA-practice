// Reversing the list using Two-Pointer Method

static class Node {
    int data;
    Node next,prev;
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
static class LL{
    Node head,tail;
    public void reverseLL(){
        if(head == null){
            return;
        }
        Node curr = head;
        Node temp = null;

        while(curr != null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }

        if(temp != null){
            tail = head;
            head = temp.prev;
        }
    }
    public void printLL(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void insertToHead(int val){
        Node n = new Node(val);
        if(head == null){
            head = n;
            tail = head;
            return;
        }
        head.prev = n;
        n.next = head;
        head = n;
    }
    public void insertToEnd(int val){
        Node n = new Node(val);
        if(head == null){
            head = n;
            tail = n;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
    }
}
void main(){
    LL l = new LL();
    l.insertToHead(10);
    l.insertToEnd(20);
    l.insertToEnd(30);
    l.insertToEnd(40);
    l.insertToEnd(50);
    l.insertToEnd(60);
    System.out.print("Before Reverse: ");
    l.printLL();
    l.reverseLL();
    System.out.print("After Reverse: ");
    l.printLL();
}