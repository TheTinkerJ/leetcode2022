package org.example.sorts;

public class CountSorter implements Sorter {
    @Override
    public SortEnum getType() {
        return SortEnum.COUNT;
    }

    @Override
    public int[] sort(int[] array) {
        return array;
    }
}
