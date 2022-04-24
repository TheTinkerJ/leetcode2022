package org.example.sorts;

public class QuickSorter implements Sorter {
    @Override
    public SortEnum getType() {
        return SortEnum.QUICK;
    }

    @Override
    public int[] sort(int[] array) {
        return array;
    }
}
