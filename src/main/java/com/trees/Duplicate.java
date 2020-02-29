package com.trees;

public class Duplicate {

    public Node duplicate(Node node1){
        Node dup = new Node();
        dup.data = node1.data;
        Node leftChild = node1.leftChild==null?null:duplicate(node1.leftChild);
        Node rightChild = node1.rightChild==null?null:duplicate(node1.rightChild);
        return dup;
    }

    public boolean isMirror(Node n1, Node n2){
        if((n1==null && n2!=null)||(n2==null && n1!=null) ) return false;
        if(n1==null && n2==null) return true;
        if(n1.data!=n2.data) return false;
        if(!isMirror(n1.leftChild, n2.rightChild)) return false;
        if(!isMirror(n2.leftChild, n1.rightChild)) return false;
        return true;
    }

    
}

class Node{
    int data;
    Node leftChild;
    Node rightChild;
}