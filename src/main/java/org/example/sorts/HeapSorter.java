package org.example.sorts;

public class HeapSorter implements Sorter {
    @Override
    public SortEnum getType() {
        return SortEnum.HEAP;
    }

    @Override
    public int[] sort(int[] array) {
        return array;
    }
}
