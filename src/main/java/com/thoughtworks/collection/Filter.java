package com.thoughtworks.collection;

import com.sun.org.apache.regexp.internal.RE;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        List<Integer> integers;
        integers = array.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
        return integers;
    }

    public List<Integer> filterMultipleOfThree() {
        return array.stream().filter(integer -> integer % 3 == 0).collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        return firstList.stream().filter(integer -> {
            for (Integer integer1 : secondList) {
                if (integer == integer1)
                    return true;
            }
            return false;
        }).collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (i == array.size() - 1 || array.get(i) != array.get(i + 1)) {
                integers.add(array.get(i));
            }
        }
        return integers;
    }
}