package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(integer -> integer * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(integer -> String.valueOf((char) (integer + 96))).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream().map(integer -> {
            StringBuilder stringBuilder = new StringBuilder();
            while (integer > 26) {
                int i = integer/26;
                integer%=26;
                if (integer == 0) {
                    return stringBuilder+String.valueOf((char) (i-1 + 96))+"z";
                }
                stringBuilder.append(String.valueOf((char) (i + 96)));
            }
            return stringBuilder+String.valueOf((char) (integer + 96));
        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
