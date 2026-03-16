static class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
static class SinglyLL{
    Node head;
    public void addNode(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }
    public int findMiddle(){
        Node slow = head;
        Node fast = head;
        while(fast.next != null){
            slow = slow.next;
            if(fast.next.next == null){
                return slow.data;
            }
            fast = fast.next.next;
        }
        return slow.data;
    }
}
void main(){
    Scanner sc = new Scanner(System.in);
    SinglyLL linklist = new SinglyLL();
    for(int i=0;i<5;i++){
        linklist.addNode(sc.nextInt());
    }
    int middle = linklist.findMiddle();
    System.out.println(middle);
}