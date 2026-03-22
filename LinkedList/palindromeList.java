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
    boolean isPalindrome(){
        if(head == null){
            return false;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = head;
        Node secondHalf = reverseSLL(slow.next);
        while(secondHalf != null){
            if(secondHalf.data == temp.data){
                secondHalf = secondHalf.next;
                temp = temp.next;
            }else{
                return false;
            }
        }
        return true;
    }
}
void main(){
    SinglyLL l = new SinglyLL();
    l.insert(10);
    l.insert(20);
    l.insert(30);
    l.insert(20);
    l.insert(10);
    l.print();
    System.out.println("List is palindrome : "+l.isPalindrome());
}