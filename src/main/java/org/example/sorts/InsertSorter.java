package org.example.sorts;

public class InsertSorter implements Sorter {
    @Override
    public SortEnum getType() {
        return SortEnum.INSERT;
    }

    @Override
    public int[] sort(int[] array) {
        int length = array.length;
        int preIdx,current;
        for (int i = 1; i < length; i++) {
            preIdx = i-1;
            current = array[i];
            while(preIdx >=0 && array[preIdx]>current){
                array[preIdx+1] = array[preIdx];
                preIdx--;
            }
            array[preIdx + 1] = current;
        }
        return array;
    }
}
