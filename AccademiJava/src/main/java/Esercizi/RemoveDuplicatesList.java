package Esercizi;

/*
2. Rimuovi duplicati:
Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5));
        System.out.println("Lista originale: " + numbers);
        removeDuplicates(numbers);
        System.out.println("Lista senza duplicati: " + numbers);
    }

    public static void removeDuplicates(List<Integer> list) {
        // Implementazione del metodo
    }
}

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5));
        System.out.println("Lista originale: " + numbers);

        removeDuplicates(numbers);

        System.out.println("Lista senza duplicati: " + numbers);
    }

    public static void removeDuplicates(List<Integer> list) {
        // 1. Creiamo un HashSet passando la lista originale al costruttore.
        // L'HashSet eliminerà automaticamente i duplicati (il 2 e il 4 extra).
        Set<Integer> setSenzaDuplicati = new HashSet<>(list);

        // 2. Svuotiamo la lista originale che è ancora "sporca".
        list.clear();

        // 3. Riaggiungiamo alla lista originale gli elementi puliti dal Set.
        list.addAll(setSenzaDuplicati);
    }
}