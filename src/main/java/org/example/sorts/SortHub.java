package org.example.sorts;

import java.util.Random;

public class SortHub {
    public static void main(String[] args) {
        Random rand = new Random();
        int arrSize = 10000;
        int[] array = new int[arrSize];
        for(int i=0;i<arrSize;i++){
            array[i] = rand.nextInt(100);
        }
        SorterFactory
                .get(SortEnum.SELECT)
                .ifPresent(sorter -> {
                    sorter.exec(array);
                });
    }
}
