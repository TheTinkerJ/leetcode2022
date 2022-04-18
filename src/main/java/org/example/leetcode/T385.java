package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class NestedInteger {

    Optional<Integer> numberValue;
    List<NestedInteger> listContainer;

    public NestedInteger(){
        numberValue = Optional.empty();
    }

    public NestedInteger(int value){
        numberValue = Optional.of(value);
    }

    public boolean isInteger(){
        return numberValue.isPresent();
    }

    public Integer getInteger(){
        return numberValue.get();
    }

    public void setInteger(int value){
        numberValue = Optional.of(value);
    }

    public void add(NestedInteger ni){
        listContainer = Optional.ofNullable(listContainer)
                .orElse(new ArrayList(){{
                    if(numberValue.isPresent()){
                        add(numberValue.get());
                        numberValue = Optional.empty();
                    }
                }});
        listContainer.add(ni);
    }

    public List<NestedInteger> getList(){
        return Optional.ofNullable(listContainer)
                .orElse(new ArrayList<>());
    }
}

public class T385 {

    public static void main(String[] args) {
        NestedInteger ni = new NestedInteger();
        NestedInteger no = new NestedInteger();

        ni.add(new NestedInteger(1));
        ni.add(new NestedInteger(2));
        ni.add(new NestedInteger(3));
        no.add(ni);
        System.out.printf(String.valueOf(ni));

    }
}
