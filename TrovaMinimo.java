import java.util.Scanner;
import java.util.InputMismatchException;

public class TrovaMinimo {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Input della dimensione dell'array
            System.out.print("Inserisci la dimensione dell'array: ");
            int dimensione = scanner.nextInt();
            
            // Validazione della dimensione
            if (dimensione <= 0) {
                System.out.println("Errore: La dimensione deve essere un numero positivo.");
                return;
            }
            
            // Creazione e popolamento dell'array
            int[] array = new int[dimensione];
            System.out.println("Inserisci gli elementi dell'array:");
            
            for (int i = 0; i < dimensione; i++) {
                System.out.print("Elemento " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            }
            
            // Calcolo del minimo
            int minimo = trovaMinimo(array);
            
            // Output del risultato
            System.out.println();
            System.out.println("Array: " + arrayToString(array));
            System.out.println("Valore minimo: " + minimo);
            
        } catch (InputMismatchException e) {
            System.out.println("Errore: Inserisci solo numeri interi.");
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        } finally {
            scanner.close();
        }
        
        // Test con array predefinito (commentato per default)
        // testConArrayPredefinito();
    }
    
    /**
     * Trova il valore minimo in un array di interi
     * @param array l'array di interi
     * @return il valore minimo
     * @throws IllegalArgumentException se l'array è vuoto
     */
    public static int trovaMinimo(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("L'array non può essere vuoto");
        }
        
        int minimo = array[0]; // Inizializza con il primo elemento
        
        // Scorre l'array a partire dal secondo elemento
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimo) {
                minimo = array[i];
            }
        }
        
        return minimo;
    }
    
    /**
     * Versione alternativa con enhanced for loop
     * @param array l'array di interi
     * @return il valore minimo
     */
    public static int trovaMinimoEnhanced(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("L'array non può essere vuoto");
        }
        
        int minimo = array[0];
        
        for (int elemento : array) {
            if (elemento < minimo) {
                minimo = elemento;
            }
        }
        
        return minimo;
    }
    
    /**
     * Converte un array in una stringa formattata
     * @param array l'array da convertire
     * @return la rappresentazione in stringa dell'array
     */
    public static String arrayToString(int[] array) {
        if (array == null || array.length == 0) {
            return "{}";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        
        sb.append("}");
        return sb.toString();
    }
    
    /**
     * Metodo di test con array predefinito
     */
    public static void testConArrayPredefinito() {
        System.out.println("\n=== TEST CON ARRAY PREDEFINITO ===");
        
        int[] arrayTest = {1, 2, 3, 4, 5};
        System.out.println("Array di test: " + arrayToString(arrayTest));
        
        int minimo = trovaMinimo(arrayTest);
        System.out.println("Valore minimo: " + minimo);
        
        // Test con array con numeri negativi
        int[] arrayNegativi = {-5, -2, -10, -1, -8};
        System.out.println("\nArray con negativi: " + arrayToString(arrayNegativi));
        System.out.println("Valore minimo: " + trovaMinimo(arrayNegativi));
        
        // Test con array misto
        int[] arrayMisto = {10, -5, 3, -12, 7, 0};
        System.out.println("\nArray misto: " + arrayToString(arrayMisto));
        System.out.println("Valore minimo: " + trovaMinimo(arrayMisto));
    }
}