package Esercizi;

/*
3. Trova l'elemento più frequente:
Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostFrequentElement {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 2, 5));
        int mostFrequent = findMostFrequentElement(numbers);
        System.out.println("L'elemento più frequente è: " + mostFrequent);
    }

    public static int findMostFrequentElement(List<Integer> list) {
        // Implementazione del metodo
    }
}

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentElement {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 2, 5));
        int mostFrequent = findMostFrequentElement(numbers);
        System.out.println("L'elemento più frequente è: " + mostFrequent);
    }

    public static int findMostFrequentElement(List<Integer> list) {
        if (list == null || list.isEmpty()) return 0;

        // 1. Creiamo la mappa per contare (Numero -> Quante volte appare)
        Map<Integer, Integer> fintoContatore = new HashMap<>();

        for (Integer n : list) {
            // Se il numero c'è già, aumenta il valore di 1, altrimenti parti da 0 e aggiungi 1
            fintoContatore.put(n, fintoContatore.getOrDefault(n, 0) + 1);
        }

        // 2. Cerchiamo nella mappa chi ha il valore (frequenza) più alto
        int maxFrequenza = -1;
        int elementoPiuFrequente = list.get(0);

        for (Map.Entry<Integer, Integer> entry : fintoContatore.entrySet()) {
            if (entry.getValue() > maxFrequenza) {
                maxFrequenza = entry.getValue();
                elementoPiuFrequente = entry.getKey();
            }
        }

        return elementoPiuFrequente;
    }
}