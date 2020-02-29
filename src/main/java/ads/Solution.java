//package ads;
//
//import java.util.*;
//
//public class Solution {
//    Node root;
//    public static void main(String[] args){
//        int[] x = new int[]{6,3,7,3,78,1,2};
//        Solution sol =new Solution();
//        sol.root=null;
//        sol.add(sol.root, );
//    }
//    private void setRoot(Node root){
//        this.root =root;
//    }
//    private void add(int data){
//        this.add(this.root, data);
//    }
//    private void add(Node root, int data){
//        if(root==null){
//            this.root = new Node();
//            this.root.val=data;
//        }
//        if(root.val>=data){
//            if(root.leftNode==null) {
//                Node lc= new Node();
//                lc.val=data;
//                root.leftNode=lc;
//            }else{
//                add(root.leftNode, data);
//            }
//        }else{
//            if(root.rightNode==null){
//                Node rc = new Node();
//                rc.val=data;
//                root.rightNode=rc;
//            }else{
//                add(root.rightNode, data);
//            }
//        }
//    }
//
//
//
//
//
//}
//
//class Node{
//    int val;
//    Node leftNode;
//    Node rightNode;
//
//}
//
