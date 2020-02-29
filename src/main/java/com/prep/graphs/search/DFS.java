package com.prep.graphs.search;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DFS {
    @Test
    public void test(){
        DFSNode a1 = new DFSNode(1); DFSNode a2 = new DFSNode(2); DFSNode a3 = new DFSNode(3); DFSNode a4 = new DFSNode(4);
        DFSNode a5 = new DFSNode(5);
        DFSNode a6 = new DFSNode(6);
        DFSNode a7 = new DFSNode(7);
        a1.neighbours.add(a2);
        a2.neighbours.add(a3);
        a3.neighbours.add(a4);

        a2.neighbours.add(a1);

        a3.neighbours.add(a2);
        a4.neighbours.add(a3);


        a7.neighbours.add(a1);
        a6.neighbours.add(a1);
        a5.neighbours.add(a1);

        a1.neighbours.add(a7);
        a1.neighbours.add(a6);
        a1.neighbours.add(a5);
        a5.neighbours.add(a4);
        a4.neighbours.add(a5);


        search(18, a1, false);
    }


    public boolean search(int x, DFSNode root, boolean isDFS){
        if(root==null) return false;
        if(root.id==x) return true;
        Deque<DFSNode> next  = new ArrayDeque<DFSNode>();
        if(isDFS)
            next.push(root);
        else
            next.add(root);
        while(!next.isEmpty()){
            DFSNode nextNode = isDFS?next.pop():next.poll();
            if(nextNode.isVisited) continue;
            nextNode.isVisited=true;
            System.out.println(nextNode.id);

            if(nextNode.id==x) return true;
            for(DFSNode child: nextNode.neighbours) {
                if (!child.isVisited) {
                    if(isDFS)
                         next.push(child);
                    else
                        next.add(child);
                }
            }
        }
        return false;
    }


}

class DFSNode{
    int id;
    boolean isVisited=false;
    List<DFSNode> neighbours ;
    public DFSNode(int id){
        this.id=id;
        neighbours=new ArrayList<DFSNode>();
    }
}


