package org.example.sorts;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SorterFactory {
    public static Map<SortEnum,Sorter> SorterMap = new HashMap(){{
        put(SortEnum.BUBBLE,new BubbleSorter());
        put(SortEnum.SELECT,new InsertSorter());
    }};

    public static Optional<Sorter> get(SortEnum type){
        return Optional.ofNullable(SorterMap.get(type));
    }

}
