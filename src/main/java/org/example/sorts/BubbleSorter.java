package org.example.sorts;

/**
 * 冒泡排序
 *
 */
public class BubbleSorter implements Sorter {
    @Override
    public SortEnum getType() {
        return SortEnum.BUBBLE;
    }
    @Override
    public int[] sort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len-1;i++){
            for(int j=0;j < len - i - 1;j ++ ){
                if(array[j] > array[j+1] ){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }
}
