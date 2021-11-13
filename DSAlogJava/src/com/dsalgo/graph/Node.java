package com.dsalgo.graph;

public class Node {
    String vertex;
    int weight;
    boolean isVisited;

    public Node(String vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "vertex='" + vertex + '\'' +
                ", weight=" + weight +
                ", isVisited=" + isVisited +
                '}';
    }
}
