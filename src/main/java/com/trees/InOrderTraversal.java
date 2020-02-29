package com.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    @Test
    public void testCase(){
        Integer[] test = {1,null, 2, 3,null, 4, 5};
        NodeY root = printInOrder(test);
        for(NodeY node: inOrder(root))
            System.out.println(root);
    }
    private List<NodeY> inOrder(NodeY root){
            if(root==null) return new ArrayList<NodeY>();
            List<NodeY> result = inOrder(root.left);
            result.add(root);
            result.addAll(inOrder(root.right));
            return result;
    }


    public NodeY printInOrder(Integer[] tree){
        if(tree==null||tree.length==0) return null;
        NodeY root = new NodeY(tree[0]);
        if(tree.length==1) {
            return  root;
        }
        NodeY[] nodes = new NodeY[tree.length];
        int parentIndex=0, childIndex=1;
        nodes[0]=root;
        while(childIndex<tree.length && parentIndex<tree.length){
            NodeY child=null;
            if(tree[childIndex]!=null)
            {
                 child = new NodeY(tree[childIndex]);
            }
            nodes[childIndex]=child;
            nodes[parentIndex].left=child;

            childIndex++;

            if(childIndex<tree.length){
                if(tree[childIndex]!=null)
                    child = new NodeY(tree[childIndex]);
                else child=null;
                nodes[childIndex]=child;
                nodes[parentIndex].right=child;
            }

            childIndex++;
            parentIndex++;

            while(tree[parentIndex]==null && parentIndex<tree.length) parentIndex++;
        }
        return root;
    }
}

class NodeY{
    int data;
    NodeY left, right;

    public NodeY(int d){this.data=d;}
}
