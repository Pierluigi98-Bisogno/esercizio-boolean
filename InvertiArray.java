import java.util.Scanner;
import java.util.InputMismatchException;

public class InvertiArray {
    
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
            
            // Output del risultato
            System.out.println();
            System.out.println("Array originale: " + arrayToString(array));
            System.out.println("Array invertito: " + arrayInversoToString(array));
            
            // Stampa gli elementi in ordine inverso (come richiesto)
            System.out.print("Output: ");
            stampaArrayInverso(array);
            System.out.println();
            
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
     * Stampa gli elementi dell'array in ordine inverso
     * @param array l'array da stampare
     */
    public static void stampaArrayInverso(int[] array) {
        if (array == null || array.length == 0) {
            System.out.print("Array vuoto");
            return;
        }
        
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
    }
    
    /**
     * Crea un nuovo array con gli elementi in ordine inverso
     * @param array l'array originale
     * @return un nuovo array con elementi invertiti
     */
    public static int[] invertiArray(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        
        int[] arrayInvertito = new int[array.length];
        
        for (int i = 0; i < array.length; i++) {
            arrayInvertito[i] = array[array.length - 1 - i];
        }
        
        return arrayInvertito;
    }
    
    /**
     * Inverte l'array sul posto (modifica l'array originale)
     * @param array l'array da invertire
     */
    public static void invertiArrayInPlace(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        int inizio = 0;
        int fine = array.length - 1;
        
        while (inizio < fine) {
            // Scambia gli elementi
            int temp = array[inizio];
            array[inizio] = array[fine];
            array[fine] = temp;
            
            inizio++;
            fine--;
        }
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
     * Converte un array in una stringa formattata in ordine inverso
     * @param array l'array da convertire
     * @return la rappresentazione in stringa dell'array invertito
     */
    public static String arrayInversoToString(int[] array) {
        if (array == null || array.length == 0) {
            return "{}";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        
        for (int i = array.length - 1; i >= 0; i--) {
            sb.append(array[i]);
            if (i > 0) {
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
        System.out.println("Array originale: " + arrayToString(arrayTest));
        
        System.out.print("Stampa inversa: ");
        stampaArrayInverso(arrayTest);
        System.out.println();
        
        // Test con creazione di nuovo array invertito
        int[] arrayInvertito = invertiArray(arrayTest);
        System.out.println("Nuovo array invertito: " + arrayToString(arrayInvertito));
        
        // Test con inversione in place
        int[] arrayCopia = {1, 2, 3, 4, 5};
        System.out.println("\nPrima dell'inversione in place: " + arrayToString(arrayCopia));
        invertiArrayInPlace(arrayCopia);
        System.out.println("Dopo l'inversione in place: " + arrayToString(arrayCopia));
        
        // Test con array di lunghezza diversa
        int[] arrayPari = {10, 20, 30, 40};
        System.out.println("\nArray pari: " + arrayToString(arrayPari));
        System.out.print("Inverso: ");
        stampaArrayInverso(arrayPari);
        System.out.println();
        
        int[] arrayDispari = {100, 200, 300};
        System.out.println("\nArray dispari: " + arrayToString(arrayDispari));
        System.out.print("Inverso: ");
        stampaArrayInverso(arrayDispari);
        System.out.println();
    }
}