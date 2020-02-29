package com.algos.tries;
import org.junit.Test;

import java.util.*;
public class WordConcatSol {
    @Test
    public void test(){
        Set<String> words = new HashSet<String>();
        words.add("a");
        words.add("b");
        words.add("ab");
        List<String> solutions = getConcatSolutions(words, "ab");
        for(String x: solutions)
            System.out.println(x);

    }
    public List<String> getConcatSolutions(Set<String> words, String str){
        List<String>[] solutions = new List[str.length()+1];
        solutions[0] = new ArrayList<String>();
        solutions[0].add("");
        for(int i=1; i<str.length()+1; i++){
            solutions[i]=new ArrayList<String>();
            for(int j=0; j<i; j++){
                String subString = str.substring(j, i);
                if(words.contains(str.substring(j, i))){
                    for(String x: solutions[j]){
                        solutions[i].add(x+(x==""?"":" ")+str.substring(j, i));
                    }
                }
            }
        }
        return solutions[str.length()];
    }
}
