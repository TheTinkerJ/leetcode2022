package org.example.sorts;

public enum SortEnum {
    BUBBLE("冒泡排序",1),
    INSERT("插入排序",2),
    SELECT("选择排序",3),
    MERGE("归并排序",4),
    QUICK("快速排序",5),
    BUCKET("桶排序",6),
    COUNT("计数排序",7),
    ELEMENT("基数排序",8),
    HEAP("堆排序",9)
    ;

    String typeName;
    int typeCode;

    SortEnum(String typeName,int typeCode){
        this.typeName = typeName;
        this.typeCode = typeCode;
    }

}
