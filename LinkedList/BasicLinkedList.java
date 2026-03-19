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
    public void insertStarting(int val){
        Node n1 = new Node(val);
        if(head == null){
            head = n1;
            tail = n1;
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
            tail = end;
            return;
        }
        tail.next = end;
        tail = end;
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
            tail = null;
            return;
        }
        if(head.next == null){
            head = null;
            tail = null;
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
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
    public LinkedList removeDuplicate(LinkedList l){
        if(head == null){
            return l;
        }
        HashSet<Integer> set = new HashSet<>();
        LinkedList newList = new LinkedList();
        Node temp = head;
        while(temp != null){
            if(set.add(temp.data)){
                newList.insertElement(temp.data);
            }
            temp = temp.next;
        }
        return newList;
    }
    public boolean hasCycle(){
        if(head == null) return false;
        Node slow = head;
        Node fast  = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}

void main() {
    LinkedList l1 = new LinkedList();
    l1.insertElement(10);
    l1.insertElement(20);
    l1.insertElement(30);
    l1.insertElement(10);
    l1.insertElement(50);
    l1.insertElement(30);
    l1.printList();
    LinkedList uniqueNodes = l1.removeDuplicate(l1);
    uniqueNodes.printList();

    System.out.println("List cycle detection result: "+ l1.hasCycle());
}