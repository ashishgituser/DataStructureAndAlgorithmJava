package com.dsalgo.logicmojo.arraysolvingtechniques;

public class FindElementFromWhichAllLeftAreSmallAndRightGreater {

    public static void main(String[] arg) {
        int[] n = {6, 7, 11, 15};
        System.out.println(getElement(n));
    }

    public static int getElement(int[] n) {
        int j = n[0], index = 0, i;

        for (i = 1; i < n.length; i++) {
            if (n[i] > j) {
                index = i;
                break;
            }
        }

        boolean areRightValuesHigher = true;

        for (i = index + 1; i < n.length; i++) {
            if (n[index] > n[i]) areRightValuesHigher = false;
        }
        return areRightValuesHigher ? index : -1;
    }
}
