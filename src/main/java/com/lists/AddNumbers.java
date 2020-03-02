package com.lists;

import org.junit.Test;

public class AddNumbers {

    @Test
    public void testAddition(){

        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        n1.next=n2; n2.next = n3;

        Node n4 = new Node(8);
        Node n5 = new Node(9);
        Node n6 = new Node(9);

        n4.next = n5;
        n5.next = n6;

        Node root = getAddedSum(n1, n4);
        Node next =  root;
        while(next!=null)
        {
            System.out.println(next.data);
            next = next.next;
        }

    }

    public Node getAddedSum(Node n1, Node n2){
        int carry=0;
        Node current1 = n1;
        Node current2 = n2;

        //set up root
        Node root = null;
        int sum = 0;
        if(n1!=null)
        {
            sum = n1.data;
            n1 = n1.next;
        }
        if(n2!=null){
            sum = sum+n2.data;
            n2=n2.next;
        }
        carry = sum/10;
        root=new Node(sum%10);


        Node next=root;
        while(n2!=null && n1!=null){
            sum = (carry+n2.data+n1.data)%10;
            carry = (carry+n2.data+n1.data)/10;
            next.next  = new Node(sum);
            next = next.next;
            n2=n2.next; n1 = n1.next;
        }

        while(n2!=null){
            sum = (carry+n2.data)%10;
            carry = (carry+n2.data)/10;
            next.next  = new Node(sum);
            next = next.next;
            n2=n2.next;
        }

        while(n1!=null){
            sum = (carry+n1.data)%10;
            carry = (carry+n1.data)/10;
            next.next  = new Node(sum);
            next = next.next;
            n1 = n1.next;
        }

        if(carry!=0){
            next.next = new Node(sum);
        }
        return root;
    }
}

class Node{
    int data;
    Node next;
    public Node(int data){this.data=data;}
}
