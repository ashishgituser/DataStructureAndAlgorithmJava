package com.dsalgo.disjointset;

import java.util.*;

public class MinimumSpanningTree {


    public static void main(String[] arg) {

        MinimumSpanningTree mst = new MinimumSpanningTree();

        List<Edge> edges = Arrays.asList(
                new Edge('I', 'J', 0),
                new Edge('A', 'E', 1),
                new Edge('C', 'I', 1),
                new Edge('E', 'F', 1),
                new Edge('G', 'H', 1),
                new Edge('B', 'D', 2),
                new Edge('C', 'J', 2),
                new Edge('D', 'E', 2),
                new Edge('D', 'H', 2),
                new Edge('A', 'D', 4),
                new Edge('B', 'C', 4),
                new Edge('C', 'H', 4),
                new Edge('G', 'I', 4),
                new Edge('A', 'B', 5),
                new Edge('D', 'F', 5),
                new Edge('H', 'I', 6),
                new Edge('F', 'G', 7),
                new Edge('D', 'G', 11)
        );

        edges.sort(Comparator.comparing(o -> o.weight));

        List<Edge> spanningTree = mst.createMinimumSpanningTree(edges);

        for (Edge edge : spanningTree) {
            System.out.println(edge);
        }
    }

    public List<Edge> createMinimumSpanningTree(List<Edge> edges) {
        Map<Edge, Integer> disjointMap = new HashMap<>();

        for (Edge edge : edges) {
            int groupId = find(disjointMap, edge);
            if (groupId != -1) {
                disjointMap.put(edge, groupId);
            }
        }

        return null;
    }

    // find the group in which any of the source or destination belongs to, otherwise -1
    public int find(Map<Edge, Integer> disjointMap, Edge edge) {
        if (disjointMap.isEmpty()) return 1;

        int sourceGroupId = disjointMap.entrySet().stream().filter(edgeIntegerEntry ->
                              edgeIntegerEntry.getKey().source.equals(edge.source) ||
                              edgeIntegerEntry.getKey().destination.equals(edge.source))
                            .findAny().map(Map.Entry::getValue).orElse(-1);

        int destinationGroupId = disjointMap.entrySet().stream().filter(edgeIntegerEntry ->
                edgeIntegerEntry.getKey().source.equals(edge.destination) ||
                        edgeIntegerEntry.getKey().destination.equals(edge.destination))
                .findAny().map(Map.Entry::getValue).orElse(-1);

        return sourceGroupId != -1 && destinationGroupId != -1 ?
                -1 : sourceGroupId != -1 ? sourceGroupId : destinationGroupId;
    }

    static class Edge {
        Character source;
        Character destination;
        Integer weight;

        public Edge(Character source, Character destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object obj) {
            Edge edge = (Edge) obj;
            return this.weight < edge.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }
    }
}
