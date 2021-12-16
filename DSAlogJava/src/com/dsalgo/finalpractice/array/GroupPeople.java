package com.dsalgo.finalpractice.array;

import java.util.*;

public class GroupPeople {

    public static void main(String[] arg) {
        int[] data = {3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> result = groupPeople(data);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> groupPeople(int[] groupSizes) {
        List<List<Integer>> result = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int index = 0;
        for (int size : groupSizes) {
            if (!map.containsKey(size)) {
                map.put(size, new LinkedList<>());
            }
            List<Integer> groups = map.get(size);
            groups.add(index++);
            if (groups.size() == size) {
                result.add(groups);
                map.remove(size);
            }
        }

        return result;
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> processedIndex = new HashSet<>();
        int maxGroupSize;

        for (int i = 0; i < groupSizes.length; i++) {
            maxGroupSize = groupSizes[i];
            if (!processedIndex.contains(i)) {
                List<Integer> groups = new ArrayList<>();
                for (int j = 0; j < groupSizes.length; j++) {
                    if (groups.size() == maxGroupSize) break;
                    if (!processedIndex.contains(j) && groupSizes[i] == groupSizes[j]) {
                        groups.add(j);
                        processedIndex.add(j);
                    }
                }
                result.add(groups);
            }
        }
        return result;
    }


}
