package org.example.sorts;

public class BucketSorter implements Sorter {
    @Override
    public SortEnum getType() {
        return SortEnum.BUCKET;
    }

    @Override
    public int[] sort(int[] array) {
        return array;
    }
}
