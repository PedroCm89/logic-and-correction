
/*Encontrar y devolver el primer carácter de la cadena que no se repite en ninguna otra parte de la misma.
La comprobación de repetición NO debe ser sensible a mayúsculas o minúsculas (es decir, 'a' y 'A' se consideran el mismo carácter).
Si todos los caracteres se repiten o la cadena es nula/vacía, debe devolver el carácter nulo o un valor que indique su ausencia
 (ej. \0 o un placeholder como Character.MIN_VALUE).*/

package org.example;

import java.util.HashMap;
import java.util.Map;

public class CharacterFinder {

    public Character findFirstNonRepeated(String text){
        Character nonRepeated = Character.MIN_VALUE;

        if(text == null || text.isEmpty()){
            return nonRepeated;
        }

        char[] characters = text.toLowerCase().toCharArray();
        Map<Character,Integer> worfText = new HashMap<>();

        for(char c : characters){
            worfText.put(c,worfText.getOrDefault(c,0)+1);
        }

        for(char c : characters){
            if(worfText.get(c)==1) {
                nonRepeated = c;
                break;
            }
        }


        return nonRepeated;
    }
}
