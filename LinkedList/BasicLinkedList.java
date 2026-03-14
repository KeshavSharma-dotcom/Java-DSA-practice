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
            return;
        }
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = n1;
    }
    public void insertStarting(int val){
        Node n1 = new Node(val);
        if(head == null){
            head = n1;
            return;
        }
        n1.next = head;
        head = n1;
        if(head.next == null){
            tail = head;
        }
    }
    public void insertAtEnd(int val){
        Node end = new Node(val);
        if(head == null){
            head = end;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = end;
    }
    public void deleteFromStart(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }
    public void deleteFromEnd(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
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
    }
}


void main() {
    LinkedList l1 = new LinkedList();
    l1.insertElement(10);
    l1.insertElement(20);
    l1.insertElement(30);
    l1.insertElement(40);
    l1.printList();
}