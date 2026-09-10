class LRUCache {
    class Node{
        int key,value;
        Node prev,next;

        Node(int key,int value){
            this.key = key;
            this.value=value;
        }
    }

    private Map <Integer,Node> map;
    private Node head,tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node (-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
     
    public void inserted(Node node){
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;

    }

    public int get(int key) {
      if(!map.containsKey(key)) return -1;
      Node node = map.get(key);
      remove(node);
      inserted(node);
      return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            inserted(node);
        }
        else{
            if(map.size()==capacity){
                Node oldNode = tail.prev;
                remove(oldNode);
                map.remove(oldNode.key);
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            inserted(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */