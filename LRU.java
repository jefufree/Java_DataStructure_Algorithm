public class LRUCache {
    
    
    public class DoublyListNode {
        public DoublyListNode prev;
        public DoublyListNode next;
        public int key;
        public int value;
        public DoublyListNode(){
            
        }
        public DoublyListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    
    HashMap<Integer, DoublyListNode> map;
    DoublyListNode head;
    DoublyListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, DoublyListNode>(capacity);
        this.head=new DoublyListNode();
        this.tail=new DoublyListNode();
        this.capacity = capacity;
    }
    
    public int get(int key) {
            if(map.containsKey(key)){
                DoublyListNode cur = map.get(key);
                if(cur.prev!=head){
                    if(cur.next==tail){
                        cur.prev.next = tail;
                        tail.prev = cur.prev;
                    }else{
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }
                    cur.next = head.next;
                    head.next.prev= cur;
                    cur.prev = head;
                    head.next = cur;
                }
                return cur.value;
            }else{
                return -1;
            }
    }
    
    public void set(int key, int value) {
        DoublyListNode cur = new DoublyListNode(key,value);
        if(map.size()==0){
            head.next = cur;
            cur.prev = head;
            cur.next = tail;
            tail.prev = cur;
            
            map.put(key,cur);
        }else{
            if(!map.containsKey(key)){
                if(map.size()>=capacity){
                    int discardKey=tail.prev.key;
                    tail.prev = tail.prev.prev;
                    tail.prev.next = tail;
                    map.remove(discardKey);
                }
                cur.next = head.next;
                head.next.prev = cur;
                head.next = cur;
                cur.prev = head;
                map.put(key,cur);
                
            }else{
                cur = map.get(key);
                cur.value = value;
                map.put(key,cur);
                if(cur.prev!=head){
                    if(cur.next==tail){
                        cur.prev.next = tail;
                        tail.prev = cur.prev;
                    }else{
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }
                    cur.next = head.next;
                    head.next.prev= cur;
                    cur.prev = head;
                    head.next = cur;
                }
            }
        }
    }
}
