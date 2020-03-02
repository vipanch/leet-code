package com.graphs;

import java.lang.reflect.Array;
import java.util.*;

public class TopologicalSort {

    public void printInTopolicalOrder(int[][] edges){
        boolean[] hasSuccesor = new boolean[edges.length];
        List<Integer>[] adjList = getAdjacencyList(edges, hasSuccesor);
        Set<Integer> hasNoSuccesors = new HashSet<>();
        for(int i=0; i<edges.length; i++){
            if(hasSuccesor[i]==false)
                hasNoSuccesors.add(i);
        }

        Set<Integer> getTopologicalOrder = new TreeSet<>();
        for(Integer node: hasNoSuccesors){
            if(!getTopologicalOrder.contains(node))
                getAllChildren(node, adjList, getTopologicalOrder);
        }

        for(Integer x: getTopologicalOrder)
            System.out.print(x+"\t");
    }

    private void getAllChildren(Integer node, List<Integer>[] adjList, Set<Integer> ans){
        for(Integer x: adjList[node]){
            getAllChildren(x, adjList, ans);
        }
        if(!ans.contains(node))
            ans.add(node);
    }

    private List<Integer>[] getAdjacencyList(int[][] edges, boolean[] hasSuccesor){
        List<Integer>[] adjList =  new List[edges.length];
        int i=0;
        for(int[] row: edges){
            int j=0;
            for(int cell: row) {
                if (adjList[j] == null) adjList[j] = new ArrayList<>();
                if (cell < Integer.MAX_VALUE){
                    adjList[j].add(i);
                    hasSuccesor[i] = true;

                }
                j++;
            }
            i++;
        }
        return adjList;
    }
}
