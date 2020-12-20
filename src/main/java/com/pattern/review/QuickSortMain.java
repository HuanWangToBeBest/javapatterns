package com.pattern.review;

public class QuickSortMain {

    public static void main(String[] args) {
        int[] sort = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        QuickSort.quickSort(sort,0,12);
        for (int value : sort) {
            System.out.println(value);
        }
    }
}
