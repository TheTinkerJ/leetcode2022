package org.example.sorts;

/**
 * 做一个 `策略 + 工厂` 模式的多排序算法
 */
public interface Sorter {

    SortEnum getType();
    int[] sort(int[] array);

    default int[] exec(int[] array){
        System.out.println("Sort algo:" + this.getType().typeName);
        System.out.print("before:\t");
        for(int elem:array){
            System.out.print(elem+" ");
        }
        System.out.println();

        Long start = System.currentTimeMillis();
        int[] arrayAfterSort = sort(array);
        Long end = System.currentTimeMillis();
        System.out.print("after:\t");
        for(int elem:arrayAfterSort){
            System.out.print(elem+" ");
        }
        System.out.println();
        System.out.println(end);
        System.out.println(start);
        System.out.println("time mills:\t"+(end-start));
        return array;
    }
}
