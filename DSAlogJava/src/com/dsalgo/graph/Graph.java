package com.dsalgo.graph;

import java.util.*;

import static java.util.Objects.nonNull;

public class Graph {
    private final Map<String, List<Node>> edges = new HashMap<>();

    public static void main(String[] arg) {
        Graph graph = new Graph();

        graph.addEdge("A", new Node("B", 2));
        graph.addEdge("A", new Node("C", 7));
        graph.addEdge("B", new Node("D", 1));
        graph.addEdge("C", new Node("E", 3));
        graph.addEdge("E", new Node("B", 3));
        graph.addEdge("E", new Node("D", 3));

        graph.printGraphEdges();
        //graph.dfsTraversal("A");

        graph.bfsTraversal("A");

        //System.out.println(graph.isConnected("A", "C"));
        //System.out.println(graph.isConnected("sd", "D"));
    }

    public void addEdge(String source, Node destination) {
        if (!edges.containsKey(source))
            addVertex(source);

        if (!edges.containsKey(destination.vertex))
            addVertex(destination.vertex);

        edges.get(source).add(0, destination);
    }

    public void addVertex(String vertex) {
        edges.put(vertex, new LinkedList<>());
    }

    public void dfsTraversal(String givenVertex) {
        Set<String> visited = new HashSet<>();
        if (!edges.isEmpty()) {
            Stack<String> traversalStack = new Stack<>();
            traversalStack.push(givenVertex);

            while (!traversalStack.isEmpty()) {
                String vertex = traversalStack.pop();

                if (!visited.contains(vertex)) {
                    System.out.println("Visited: " + vertex);
                    visited.add(vertex);

                    List<Node> nodes = edges.get(vertex);

                    if (nonNull(nodes)) {
                        for (int i = 0; i < nodes.size(); i++) {
                            Node node = nodes.get(i);
                            if (!visited.contains(node.vertex))
                                traversalStack.push(node.vertex);
                        }
                    }
                }
            }
        }
    }

    public void bfsTraversal(String givenVertex) {
        Set<String> visited = new HashSet<>();
        if (!edges.isEmpty()) {
            Queue<String> traversalQueue = new LinkedList<>();
            traversalQueue.add(givenVertex);

            while (!traversalQueue.isEmpty()) {

                String vertex = traversalQueue.poll();

                if (!visited.contains(vertex)) {
                    System.out.println("Visited: " + vertex);
                    visited.add(vertex);

                    List<Node> nodes = edges.get(vertex);

                    if (nonNull(nodes)) {
                        for (int i = 0; i < nodes.size(); i++) {
                            Node node = nodes.get(i);

                            if (!visited.contains(node.vertex)) {
                                traversalQueue.add(node.vertex);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isConnected(String sourceVertex, String targetVertex) {
        List<Node> connectedEdges = edges.get(sourceVertex);
        return nonNull(connectedEdges) && edges.get(sourceVertex).stream()
                .anyMatch(edge -> edge.vertex.equalsIgnoreCase(targetVertex));
    }

    public void printGraphEdges() {
        edges.entrySet().stream().forEach(entrySet -> {
            System.out.println("Vertex (" + entrySet.getKey() + ") -> " + entrySet.getValue());
        });
    }

    public List<Node> getEdges(String vertex) {
        return edges.get(vertex);
    }
}
