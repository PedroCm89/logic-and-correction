/*Crea una clase llamada StringProcessor con un método llamado extractNumbersAndSum(String text) que acepte una cadena de texto.
El método debe hacer lo siguiente:

1-Extraer todos los números enteros positivos que se encuentren en la cadena.
 Los números pueden estar separados por cualquier carácter no numérico (espacios, letras, signos, etc.).

2-Sumar todos esos números extraídos.

3-Devolver la suma total.*/

package org.example;

public class StringProcessor {

    public int extractNumbersAndSum(String text){
        int sumResult =0;

        if(text==null || text.isEmpty()){
            return sumResult;
        }

        String[] words = text.split("\\D+");
        for(int i =0 ; i< words.length;i++ ){
            if(!words[i].isEmpty()) {
                sumResult += Integer.parseInt(words[i]);
            }
        }
        return sumResult;
    }

}
