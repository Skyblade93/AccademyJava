package Esercizi;

/*. Inverti una lista:
        Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Lista originale: " + numbers);
        reverseList(numbers);
        System.out.println("Lista invertita: " + numbers);
    }

    public static void reverseList(List<Integer> list) {
        // Implementazione del metodo
    }
}
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Lista originale: " + numbers);
        reverseList(numbers);
        System.out.println("Lista invertita: " + numbers);
    }

    public static void reverseList(List<Integer> list) {
        // Usiamo un ciclo for che arriva a metà lista
        for (int i = 0; i < list.size() / 2; i++) {
            // 1. Salviamo l'elemento attuale in una variabile temporanea (temp)
            int temp = list.get(i);

            // 2. Calcoliamo la posizione dell'elemento corrispondente alla fine
            int fine = list.size() - 1 - i;

            // 3. Mettiamo l'elemento della fine al posto di quello all'inizio
            list.set(i, list.get(fine));

            // 4. Mettiamo il valore salvato in temp al posto di quello alla fine
            list.set(fine, temp);
        }
    }
}

