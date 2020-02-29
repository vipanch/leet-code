package com.algos.tries;

import org.junit.Test;

public class Trie {
    TrieNode root;
    public Trie(){
        root = new TrieNode(' ');
    }

    public void insert(String str){
        if(str.equals(""))
            root.isEndNode=true;
        else
        {
            char ch1 =str.charAt(0);
            if(root.children[ch1-'a']!=null){
                root.children[ch1-'a'].insert(str.substring(1));
            }
            else{
                root.children[ch1-'a']=new TrieNode(ch1);
                root.children[ch1-'a'].insert(str.substring(1));
            }
        }
    }

    public boolean search(String str){
        if(str.equals("")) return root.isEndNode;
        if(root.children[str.charAt(0)-'a']==null) return false;
        return root.children[str.charAt(0)-'a'].search(str.substring(1));
    }


    @Test
    public void testCase(){
        Trie trie = new Trie();
        trie.insert("a");
        trie.insert("ab");
        boolean exists = trie.search("a");
        exists = trie.search("ab");
        exists = trie.search("c");
        exists = trie.search("");
        System.out.print(exists);
    }
}
