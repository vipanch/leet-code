package com.algos.tries;

public class TrieNode {
    char ch;
    TrieNode[] children;
    boolean isEndNode;

    public TrieNode(char ch){
        this.ch=ch;
        children = new TrieNode[26];
    }
    public boolean isWord(){return this.isEndNode;}
    public TrieNode getChild(char ch){return children[ch-'a'];}
    public boolean hasChild(char ch){return children[ch-'a']!=null;}
    public void insert(String str){  //str is child string
        if(str.length()<1) {
            this.isEndNode=true;
            return;
        }
        char ch = str.charAt(0);
        if(this.hasChild(str.charAt(0))){
            this.children[ch-'a'].insert(str.substring(1));
            return;
        }
        children[ch-'a']=new TrieNode(str.charAt(0));
        if(str.length()==1) children[ch-'a'].isEndNode=true;
        else children[ch-'a'].insert(str.substring(1));
        return;
    }
    public boolean search(String str){  //str is child string
        if(str.equals("")) {return this.isEndNode;}
        char ch2 = str.charAt(0);
        if(this.children[ch2-'a']==null) return false;
        return this.children[ch2-'a'].search(str.substring(1));
    }
}
