package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeSumaCalculator {

    /*Crea un método que reciba dos números enteros positivos, inicio y fin (start y end),
    y calcule la suma de todos los números primos que se encuentran en ese rango (incluyendo start y end si son primos).
    Requisito adicional: Si el número de inicio es mayor que el número de fin,
    deben intercambiarse automáticamente para que el rango siempre sea válido.*/

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        // Optimización: solo itera hasta la raíz cuadrada
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int sumPrimeNumbers(int star, int end){
        int sumResult =0;

        if(end < star){
            int comodin = star;
            star =end;
            end = comodin;
        }
        List<Integer>primeNumber = new ArrayList<Integer>();
        for(int i = star; i<=end;i++ ){
          if(isPrime(i)){
              sumResult+=i;
          }
        }
        return sumResult;
    }
}
