package org.example;

import java.util.LinkedList;
import java.util.List;

public class FilterEvenNumber {

    public List<Integer> filter(List<Integer> list){
        List<Integer> evenNumber = new LinkedList<>();

        for (int i=0; i<list.size() ; i++){
            if((list.get(i)%2)==0){
                evenNumber.add(list.get(i));
            }
        }

        return evenNumber;
    }

    public List<Integer> filterWithStream(List<Integer> list){

        List<Integer> evenNumber = list.stream()
                .filter(i-> (i%2)==0)
                .toList();

        return evenNumber;
    }





    }
