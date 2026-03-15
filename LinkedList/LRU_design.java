static class Node{
    int key,value;
    Node next,prev;
    Node(int key, int value){
        this.prev = null;
        this.key = key;
        this.next = null;
        this.value = value;
    }
}
static class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head,tail;
    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    public void get(int k){
        if(!map.containsKey(k)){
            System.out.println("Key not found");
            return;
        }
        Node valAtKey = map.get(k);
        remove(valAtKey);
        insertToHead(valAtKey);
        System.out.println(valAtKey.value);
    }
    public void put(int k,int val){
        if(map.containsKey(k)){
            remove(map.get(k));
        }

        if(map.size() == capacity) {
            Node leastEle = tail.prev;
            map.remove(leastEle.key);
            remove(leastEle);
            System.out.println("Removing the LRU element at :"+leastEle.key+" holding "+leastEle.value);
        }
        Node n = new Node(k,val);
        map.put(k,n);
        System.out.println("Changes key :"+n.key+" holding "+map.get(k).value);
        insertToHead(n);
    }
    public void remove(Node n){
        n.prev.next =  n.next;
        n.next.prev = n.prev;
    }
    public void insertToHead(Node n){
        n.next = head.next;
        n.prev = head;
        n.next.prev = n;
        head.next = n;
    }
}

void main() {
    LRUCache l = new LRUCache(4);
    l.put(1,2);
    l.put(2,67);
    l.put(3,3);
    l.put(4,5);
    l.put(5,4);
    l.get(2);
    l.put(6,2);
}