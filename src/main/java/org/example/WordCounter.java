package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public Map wordsCounter(String sentence){


        Map<String,Integer> count = new HashMap<>();
        if(sentence == null || sentence.isEmpty()){
            return count;
        }

        String[] words = sentence.split("[ ,.]");

        for(String word:words){
            if(!count.containsKey(word)){
                count.put(word,1);
            }else{
                int i = count.get(word).intValue();
                i++;
                count.put(word,i);
                 i=0;
                 }
        }
       return count;
    }
}
