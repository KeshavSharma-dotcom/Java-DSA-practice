static class Node{
    int data;
    int val;
    Node next,prev;
    Node(int data, int value){
        this.prev = null;
        this.data = data;
        this.next = null;
        this.val = value;
    }
}
static class LRUcache{
    int capacity;
    Map<Integer, Node> map;
    Node head,tail;
    LRUcache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
}

void main() {
}