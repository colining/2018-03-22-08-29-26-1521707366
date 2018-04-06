package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                integers.add(array[i][i1]);
            }
        }
        return integers;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                if (!integers.contains(array[i][i1]))
                    integers.add(array[i][i1]);
            }
        }
        return integers;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1}, {2}, {3}, {4, 5}};
        System.out.println(test[3][1]);
    }
}
