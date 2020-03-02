package com.trees;

import org.junit.Test;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {

        TreeNode runner = root;
        if(root==null) return root;
        while(runner!=null){
            if(runner.val>R){
                runner = runner.left;
            }else if(runner.val<L){
                runner=runner.right;
            }else{
                break;
            }
        }

        if(runner==null) return null;
        trimLeft(runner, L);
        trimRight(runner, R);
        return runner;
    }


    public void trimLeft(TreeNode root, int L){
        if(root.left==null) return;
        if(root.left.val>=L){
            trimLeft(root.left, L);
        }
        else
            root.left=null;

    }

    public void trimRight(TreeNode root, int R){
        if(root.right==null) return;
        if(root.right.val<=R)
            trimRight(root.right, R);
        else
            root.right=null;
    }

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(8);

        t3.left=t2;
        t2.left=t1;
        t3.right=t5;
        t5.left=t4;

        TreeNode ans = trimBST(t3, 2, 4);
        System.out.println(ans);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
