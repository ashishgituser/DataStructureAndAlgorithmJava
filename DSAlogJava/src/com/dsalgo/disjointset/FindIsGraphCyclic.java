package com.dsalgo.disjointset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIsGraphCyclic {

    Map<Integer, Integer> disjointSet = new HashMap<>();
    List<Pair> edges;
    int[] vertices;

    public static void main(String[] arg) {
        FindIsGraphCyclic fu = new FindIsGraphCyclic();
        fu.initializeVerticesAndEdges();

        System.out.println(fu.isCycle());
    }

    public void initializeVerticesAndEdges() {
        vertices = new int[]{0, 1, 2, 3};
        edges = Arrays.asList(
                new Pair(0, 1),
                new Pair(0, 3),
                new Pair(2, 3),
                new Pair(1, 2)
        );
    }

    public boolean isCycle() {
        for (int vertex : vertices) {
            disjointSet.put(vertex, -1);
        }

        for (Pair edge : edges) {
            int fromP = findParent(edge.source);
            int toP = findParent(edge.target);

            if (fromP == toP) return true;
            union(fromP, toP);
        }

        return false;
    }

    public int findParent(int source) {
        if (disjointSet.get(source) == -1) return source;
        return findParent(disjointSet.get(source));
    }

    public void union(int fromP, int toP) {
        fromP = findParent(fromP);
        toP = findParent(toP);
        disjointSet.put(fromP, toP);
    }

    static class Pair {
        int source;
        int target;

        public Pair(int source, int target) {
            this.source = source;
            this.target = target;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "source=" + source +
                    ", target=" + target +
                    '}';
        }
    }

}
