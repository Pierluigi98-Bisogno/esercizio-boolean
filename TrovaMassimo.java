import java.util.Scanner;

public class TrovaMassimo {
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
            
            // Trova il massimo
            int massimo = trovaMassimo(array);
            
            // Mostra l'array e il risultato
            System.out.println("\nArray: " + arrayToString(array));
            System.out.println("Valore massimo: " + massimo);
            
        } catch (Exception e) {
            System.out.println("Errore: Inserisci numeri validi!");
        } finally {
            scanner.close();
        }
    }
    
    // Metodo per trovare il valore massimo nell'array
    public static int trovaMassimo(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("L'array non può essere vuoto");
        }
        
        int massimo = array[0]; // Inizializza con il primo elemento
        
        // Scorre l'array per trovare il massimo
        for (int i = 1; i < array.length; i++) {
            if (array[i] > massimo) {
                massimo = array[i];
            }
        }
        
        return massimo;
    }
    
    // Metodo alternativo usando enhanced for loop
    public static int trovaMaxsimoEnhanced(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("L'array non può essere vuoto");
        }
        
        int massimo = array[0];
        
        for (int elemento : array) {
            if (elemento > massimo) {
                massimo = elemento;
            }
        }
        
        return massimo;
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
    
    // Metodo di test con array predefinito
    public static void testConArrayPredefinito() {
        int[] arrayTest = {1, 2, 3, 4, 5};
        int massimo = trovaMassimo(arrayTest);
        
        System.out.println("Test con array predefinito:");
        System.out.println("Array: " + arrayToString(arrayTest));
        System.out.println("Massimo: " + massimo);
    }
}