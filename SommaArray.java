import java.util.Scanner;

public class SommaArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Chiedi la dimensione dell'array
            System.out.print("Inserisci la dimensione dell'array: ");
            int dimensione = scanner.nextInt();
            
            // Verifica che la dimensione sia valida
            if (dimensione <= 0) {
                System.out.println("Errore: La dimensione deve essere un numero positivo!");
                return;
            }
            
            // Crea l'array
            int[] array = new int[dimensione];
            
            // Chiedi all'utente di inserire gli elementi
            System.out.println("Inserisci gli elementi dell'array:");
            for (int i = 0; i < dimensione; i++) {
                System.out.print("Elemento " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            }
            
            // Calcola la somma
            int somma = calcolaSomma(array);
            
            // Mostra l'array e il risultato
            System.out.println("\nArray: " + arrayToString(array));
            System.out.println("Somma degli elementi: " + somma);
            
        } catch (Exception e) {
            System.out.println("Errore: Inserisci numeri validi!");
        } finally {
            scanner.close();
        }
    }
    
    // Metodo per calcolare la somma degli elementi
    public static int calcolaSomma(int[] array) {
        int somma = 0;
        for (int elemento : array) {
            somma += elemento;
        }
        return somma;
    }
    
    // Metodo per convertire l'array in stringa
    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("}");
        return sb.toString();
    }
    
    // Metodo alternativo con array predefinito (per test)
    public static void testConArrayPredefinito() {
        int[] arrayTest = {1, 2, 3, 4, 5};
        int somma = calcolaSomma(arrayTest);
        
        System.out.println("Test con array predefinito:");
        System.out.println("Array: " + arrayToString(arrayTest));
        System.out.println("Somma: " + somma);
    }
}