package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int n1 = leftBorder;
        if (leftBorder > rightBorder) {
            leftBorder = rightBorder;
            rightBorder = n1;
        }
        int a1 = leftBorder%2==0?leftBorder:leftBorder+1;
        int an = rightBorder%2==0?rightBorder:rightBorder-1;
        int n = (an-a1)/2+1;
        return (a1+an)*n/2;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int n1 = leftBorder;
        if (leftBorder > rightBorder) {
            leftBorder = rightBorder;
            rightBorder = n1;
        }
        int a1 = leftBorder%2==0?leftBorder+1:leftBorder;
        int an = rightBorder%2==0?rightBorder-1:rightBorder;
        int n = (an-a1)/2+1;
        return (a1+an)*n/2;

    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int a = arrayList.stream().mapToInt(integer -> integer * 3 + 2).sum();
        return a;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 != 0) {
                arrayList.set(i, arrayList.get(i) * 3 + 2);
            }
        }
        return arrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int a = arrayList.stream().mapToInt(integer -> {
            if (integer % 2 != 0) {
                return integer*3+5;
            }
            return 0;
        }).sum();
        return a;
    }



    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        ArrayList<Integer> integers = new ArrayList<>();
        arrayList.forEach(integer -> {
            if (integer % 2 == 0) {
                integers.add(integer);
            }
        });
        if (integers.size() % 2 != 0) {
            return integers.get(integers.size() / 2);
        }else {
            return (integers.get(integers.size()/2-1)+integers.get(integers.size()/2))/2;
        }
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        ArrayList<Integer> integers = new ArrayList<>();
        arrayList.forEach(integer -> {
            if (integer % 2 == 0) {
                integers.add(integer);
            }
        });
        return integers.stream().mapToInt(x->x).sum()/integers.size();

    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        ArrayList<Integer> integers = new ArrayList<>();
        arrayList.forEach(integer -> {
            if (integer % 2 == 0) {
                integers.add(integer);
            }
        });
        return integers.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        ArrayList<Integer> integers = new ArrayList<>();
        arrayList.forEach(integer -> {
            if (integer % 2 == 0) {
                integers.add(integer);
            }
        });
        return integers;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 2 == 0 && o2 % 2 != 0) {
                    return -1;
                }
                else if (o1%2==0 && o2%2==0){
                    return o1-o2;
                } else if (o1 % 2 != 0 && o2 % 2 != 0) {
                    return o2-o1;
                }
                return 0;
            }
        });
        return arrayList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        for (int i = arrayList.size() - 1; i > 0; i--) {
            arrayList.set(i, (arrayList.get(i) + arrayList.get(i - 1)) * 3);
        }
        arrayList = arrayList.subList(1, arrayList.size());
        return arrayList;
    }

}
