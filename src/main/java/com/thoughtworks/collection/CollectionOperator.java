package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (left < right) {
            for (int i = left; i <= right; i++) {
                integers.add(i);
            }
        } else {
            for (int i = left; i >= right; i--) {
                integers.add(i);
            }
        }
        return integers;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (left < right) {
            for (int i = left; i <= right; i++) {
                if (i%2==0) {
                    integers.add(i);
                }
            }
        } else {
            for (int i = left; i >= right; i--) {
                if (i%2==0) {
                    integers.add(i);
                }
            }
        }
        return integers;
    }

    public List<Integer> popEvenElments(int[] array) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                integers.add(array[i]);
            }
        }
        return integers;
    }

    public int popLastElment(int[] array) {
        return array.length!=0?array[array.length-1]:0;
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i : firstArray) {
            for (int i1 : secondArray) {
                if (i == i1) {
                    integers.add(i);
                }
            }
        }
        return integers;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> list = new ArrayList<>();
        for (Integer integer : firstArray) {
            list.add(integer);
        }
        for (Integer integer : secondArray) {
            if (!list.contains(integer)) {
                list.add(integer);
            }
        }
        return list;
    }
}
