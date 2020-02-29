package ads.tree;


public class DoublyLinkedList {
    Node root;
    Node lastNode;

    public void insert(int data){
        if(root!=null){
            lastNode = root.insert(data);
        }else{
            Node first = new Node(data);
            first.next=root;
            root = first;
            if(first.next!=null)
                first.next.previous=first;
        }
    }

    public Integer deleteLast(){
        Integer  last = Integer.MIN_VALUE;
        if(root==lastNode)
            root=null;
        else {
            last = lastNode.data;
            this.lastNode = lastNode.previous;
            lastNode.next = null;
        }
        return last;
    }
}


class Node {
    int data;
    Node next;
    Node previous;

    public Node(int data){
        this.data = data;
    }

    public Node insert(int data){
        if(this.next==null) {
            Node next = new Node(data);
            this.next = next;
            next.previous = this;
            return next;
        }else{
            return this.next.insert(data);
        }
    }
}
