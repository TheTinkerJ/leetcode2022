package org.example.sorts;

public class MergeSorter implements Sorter {
    @Override
    public SortEnum getType() {
        return SortEnum.MERGE;
    }

    @Override
    public int[] sort(int[] array) {
        return array;
    }
}
