class LRUCache {

    class Node{
        int key, value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    List<Node>list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>();
    }
    
    public int get(int key) {
        for(int i=0;i<list.size(); i++){
            if(list.get(i).key == key){
                Node node = list.remove(i);
                list.add(node);
                return node.value;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).key == key){
                list.remove(i);
                list.add(new Node(key,value));
                return;
            }
        }
        if(list.size() == capacity){
            list.remove(0);
        }

        list.add(new Node(key,value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */