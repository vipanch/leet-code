package com.prep.graphs;
import java.util.*;

public class Graph {
    int v;
    Map<Integer, Integer>[] adjacency;

    public Graph(int v){this.v = v;
        adjacency = new Map[v];
    }

    public void addEdge(int i, int j, int weight){
        Map<Integer, Integer> Ilinks  = adjacency[i];
        if(Ilinks==null) Ilinks = new HashMap<Integer, Integer>();

        Map<Integer, Integer> Jlinks  = adjacency[j];
        if(Jlinks==null) Jlinks = new HashMap<Integer, Integer>();

        Ilinks.put(j, weight);
        Jlinks.put(i, weight);
    }


}

class Node{
    int id;
    int data;
    List<Edge> adjacentEdges;
}

class Edge{
    int v, u,  weight;
    public Edge(int v, int u, int weight){
        this.v = v; this.u=u; this.weight=weight;
    }
}
