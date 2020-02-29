package com.prep.graphs.search;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class BellmanFord {

    @Test
    public void test(){
        int[][] weights = { {0, 7, 3, 17},
                            {7, 0, 2,  4},
                            {3, 2, 0,  9},
                            {17, 4, 9, 0}};
        int shortest = getShortestPath(weights, 4, 0, 3);
        System.out.println(shortest);
    }

    public int getShortestPath(int[][] weights, int N, int source, int target){
        List<Integer>[] adjacencyLists = getAdjacencyLists(weights,N);
        int[] distances = getDistanceVector(N, source);
        boolean[] isFound = new boolean[N];
        isFound[source]=true;
        boolean[] isInPotentials = new boolean[N];

        List<Integer> potentials = new ArrayList<>();

        for(Integer adj: adjacencyLists[source]){
            distances[adj]=distances[adj]<distances[source]+weights[source][adj]?distances[adj]:weights[source][adj];
            if(!isInPotentials[adj] && !isFound[adj])
                potentials.add(adj);
        }
        Comparator<Integer> func = (Integer x, Integer y) -> distances[x] - distances[y];
        while(!potentials.isEmpty()){
            Integer least = potentials.stream().min(func).get();
            potentials.remove(least);
            isFound[least]=true;
            for(Integer adj: adjacencyLists[least]){
                distances[adj]=distances[adj]<distances[least]+weights[least][adj]?distances[adj]:distances[least]+weights[least][adj];
                if(!isFound[adj] && !isInPotentials[adj]) {
                    potentials.add(adj);
                    isInPotentials[adj]=true;
                }
            }
        }

        return distances[target];
    }


    private List<Integer>[] getAdjacencyLists(int[][] weights, int N) {
        List<Integer> adjacencyList[] = new List[N];
        for(int i=0; i<N; i++){
            adjacencyList[i]=new ArrayList<Integer>();
            int j=0;
            for(int x: weights[i]){
                if(x<Integer.MAX_VALUE)
                    adjacencyList[i].add(j);
                j++;
            }
        }
        return adjacencyList;
    }

    private int[] getDistanceVector(int N, int source){
        int def = Integer.MAX_VALUE;
        int[] distance = new int[N];
        for(int i=0; i<N; i++)
            distance[i]=def;
        distance[source]=0;
        return distance;
    }


}

class GraphNode{
    int distance;
    int id;
}
