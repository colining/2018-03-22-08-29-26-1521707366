package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.DoubleStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }

    public double getMinimum() {
        return arrayList.stream().reduce(Integer.MAX_VALUE,Integer::min);
    }

    public double getAverage() {
        Double result = arrayList.stream().mapToDouble(Integer::doubleValue).average().orElse(Double.NaN);;
        return result;
    }

    public double getOrderedMedian() {
        DoubleStream doubleStream = arrayList.stream().mapToDouble(Integer::doubleValue).sorted();
        double median = arrayList.size()%2 == 0?
                doubleStream.skip(arrayList.size()/2-1).limit(2).average().getAsDouble():
                doubleStream.skip(arrayList.size()/2).findFirst().getAsDouble();
        return median;
    }

    public int getFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                return arrayList.get(i);
            }
        }
        return 0;
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList1) {
        if (arrayList1.size() != arrayList.size()) {
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != arrayList1.get(i)) {
                return false;
            }
        }
        return true;
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
//        singleLink = new SingleLinkList();
        for (Integer integer : arrayList) {
            singleLink.addTailPointer(integer);
        }
        int mid = arrayList.size()/2;
        int sum = (Integer) singleLink.getNode(mid)+(Integer)singleLink.getNode(mid+1);
        return (double) sum/2;
    }

    public int getLastOdd() {
        for (int i = arrayList.size()-1; i >=0; i++) {
            if (arrayList.get(i) % 2 != 0) {
                return arrayList.get(i);
            }
        }
        return -1;
}

    public int getIndexOfLastOdd() {
        for (int i = arrayList.size()-1; i >=0; i++) {
            if (arrayList.get(i) % 2 != 0) {
                return i;
            }
        }
        return -1;
    }
}
