package org.example.sorts;

public class SelectSorter implements Sorter {
    @Override
    public SortEnum getType() {
        return SortEnum.SELECT;
    }

    @Override
    public int[] sort(int[] array) {
        int minIdx = 0;
        int len = array.length;
        for(int i = 0;i<len;i++){
            minIdx = i;
            for(int j = i+1; j < len; j++){
                if(array[j] < array[minIdx]){
                    minIdx = j;
                }
            }
            if(minIdx!=i){
                int tmp = array[i];
                array[i] = array[minIdx];
                array[minIdx] = tmp;
            }
        }
        return array;
    }
}
