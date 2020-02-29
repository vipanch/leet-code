package com.prep.graphs.search;

import org.junit.Test;

import java.util.Set;
import java.util.*;

public class Kruskal {

    @Test
    public void test(){
        int[][] weights = { {0, 2, 1, 6},
                            {2, 0, 4, 2},
                            {1, 4, 0, 2},
                            {6, 2, 2, 0}
                            };
        for(Edge e: getMinimumSpanningTree(weights, weights.length)){
            System.out.println(e.st+"--"+e.end+"--"+weights[e.st][e.end]);
        }
    }

    public Set<Edge> getMinimumSpanningTree(int[][] weights, int N){
        List<Integer>[] adjacencyLists = getAdjacencyLists(weights, N);
        int[] keyValues = new int[N];
        keyValues[0]=0;
        for(int i=1; i<keyValues.length; i++){
            keyValues[i]=Integer.MAX_VALUE;
        }
        Set<Integer> potentials = new HashSet<>();
        potentials.add(0);

        boolean[] isInPotentials = new boolean[N];
        isInPotentials[0]=true;

        Integer[] edgeFrom = new Integer[N];
        edgeFrom[0]=-1;
        Set<Edge> resultSet = new HashSet<>();

        while(!potentials.isEmpty()) {
            Integer findMin = potentials.stream().filter(e -> keyValues[e] < Integer.MAX_VALUE).min((x, y) -> keyValues[x] - keyValues[y]).orElse(null);
            if (findMin == null) return resultSet;
            potentials.remove(findMin);
            if (findMin > 0){
                Edge edge = new Edge();
                edge.st = edgeFrom[findMin];
                edge.end = findMin;
                resultSet.add(edge);
            }

            for(Integer adj: adjacencyLists[findMin]) {
                int updated = weights[findMin][adj];
                if (!isInPotentials[adj]) {
                    potentials.add(adj);
                    isInPotentials[adj]=true;
                }
                if(updated<keyValues[adj]){
                    keyValues[adj] = updated;
                    edgeFrom[adj]=findMin;
                }
            }
        }
        return resultSet;
    }

    List<Integer>[] getAdjacencyLists(int[][] weights, int N){
        List<Integer>[] res = new List[N];

        for(int i=0; i<weights.length; i++){
            res[i] = new ArrayList<>();
            for(int j=0; j<weights[0].length; j++){
                if(weights[i][j]<Integer.MAX_VALUE)res[i].add(j);
            }
        }
        return res;
    }
}

class KNode{
    int id;
    int value;
}

class Edge{
    int st, end, weight;
}
