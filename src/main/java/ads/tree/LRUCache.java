package ads.tree;

import java.util.HashMap;

public class LRUCache {
    int capacity;
    int currentCapacity=0;
    HashMap<Integer, Node> data;
    DoublyLinkedList listNode;
    public LRUCache(int capacity){
        this.capacity = capacity;
        data = new HashMap<Integer, Node>();
        listNode = new DoublyLinkedList();
    }

    public void put(int data){
        if(this.data.containsKey(data))
            return;
        else{
            if(currentCapacity==capacity){
                Integer leastUsed = listNode.deleteLast();
                this.data.remove(leastUsed);
                Node next = new Node(data);
                this.data.put(data, next);
            }
        }

    }
}
