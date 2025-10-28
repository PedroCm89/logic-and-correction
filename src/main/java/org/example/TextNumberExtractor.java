package org.example;

public class TextNumberExtractor {

    public int sumNumbersWithoutRegex(String text){
        StringBuilder concurrentNumber = new StringBuilder();
        char concurrentChar;
        int resultSum =0;

        if( text==null ){
            return resultSum;
        }

        for (int i =0; i<text.length(); i++){
            concurrentChar= text.charAt(i);

            if(Character.isDigit(concurrentChar)){
                concurrentNumber.append(concurrentChar);

            }else{
                if (concurrentNumber.length()>0) {
                    String result = concurrentNumber.toString();
                    resultSum += Integer.parseInt(result);
                    concurrentNumber.setLength(0);
                }
            }
        }
        if (concurrentNumber.length() > 0) {
            String result = concurrentNumber.toString();
            resultSum += Integer.parseInt(result);
        }
        return resultSum;
    }
}
