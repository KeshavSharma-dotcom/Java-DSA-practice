// Removing last nth node
static class Node {
    int data,index;

    Node next;
    Node(int index, int data){
        this.index = index;
        this.data = data;
        this.next = null;
    }
}

static class LL{
    Node head,tail;
    int size;
    public void insert(int index, int value){
        Node node = new Node(index, value);
        if(head == null){
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        size++;
        tail = node;
    }
    public void removeN(int Q) {
        Node temp = new Node(0,0);
        temp.next = head;

        Node slow = temp;
        Node fast = temp;
        for (int i=0;i<Q;i++){
            fast = fast.next;
        }
        System.out.println(fast.next.data);
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(slow.next.data);
        slow.next = slow.next.next;
        head = temp.next;
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
void main(){
    LL l = new LL();
    l.insert(1,10);
    l.insert(2,20);
    l.insert(3,30);
    l.insert(4,40);
    l.insert(5,50);
    l.insert(6,60);
    l.insert(7,70);
    l.insert(8,80);
    l.insert(9,90);
    System.out.println(l.size);
    l.removeN(2);
    l.printList();
}