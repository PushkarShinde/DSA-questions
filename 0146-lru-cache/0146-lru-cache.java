class LRUCache {
    //custom DLL
    private static class Node{
        int key, val;
        Node pre, next;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }

    private final int cap;
    private final Map<Integer, Node> map; //key->Node in dll
    private final Node head, tail; //head= MRU, tail=LRU
    public LRUCache(int capacity){
        this.cap=capacity;
        this.map=new HashMap<>();

        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.pre=head;
    }
    
    public int get(int key){
        if(!map.containsKey(key)) return -1;

        Node node=map.get(key);
        moveToFront(node);//we accessed it, so moving it to front of the DLL (MRU)  
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            moveToFront(node);
        }else{
            if(map.size()==cap) removeLRU();
            
            Node node=new Node(key, value);
            map.put(key, node);
            addToFront(node);
        }
    }

    private void addToFront(Node node){
        //MRU
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }

    private void remove(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    private void moveToFront(Node node){
        remove(node);
        addToFront(node);
    }

    private void removeLRU(){
        Node lru=tail.pre;
        remove(lru);
        map.remove(lru.key);//ye almost bhulne hi wala tha
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */