package com.dsalgo.logicmojo.arraysolvingtechniques;

import java.util.Arrays;

public class MaxPlatformsRequired {

    public static void main(String[] arg) {
        double[] arrival = {1.00, 1.40, 1.50, 2.00, 2.15, 4.00};
        double[] departure = {1.10, 3.00, 2.20, 2.30, 3.15, 6.00};

        System.out.println(maxPlatForm(arrival, departure));
    }

    public static int maxPlatForm(double[] arrival, double[] departure) {
        int platFormsRequired = 0, maxPlatForms = 0, i = 0, j = 0;
        Arrays.sort(departure);


        while (i < arrival.length && j < departure.length) {

            if (arrival[i] < departure[j]) {
                platFormsRequired++;
                i++;

                if (platFormsRequired > maxPlatForms) maxPlatForms = platFormsRequired;
            } else {
                platFormsRequired--;
                j++;
            }

        }

        return maxPlatForms;
    }

}
