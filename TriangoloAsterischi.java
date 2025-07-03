import java.util.Scanner;
import java.util.InputMismatchException;

public class TriangoloAsterischi {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Input del numero di righe
            System.out.print("Inserisci il numero di righe (n): ");
            int n = scanner.nextInt();
            
            // Validazione del numero
            if (n <= 0) {
                System.out.println("Errore: Il numero deve essere positivo.");
                return;
            }
            
            // Stampa del triangolo
            System.out.println("\nTriangolo di asterischi crescente:");
            stampaTriangoloCresce(n);
            
        } catch (InputMismatchException e) {
            System.out.println("Errore: Inserisci solo numeri interi.");
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        } finally {
            scanner.close();
        }
        
        // Test con esempi predefiniti (commentato per default)
        // testConEsempiPredefiniti();
    }
    
    /**
     * Stampa un triangolo di asterischi crescente
     * @param n numero di righe del triangolo
     */
    public static void stampaTriangoloCresce(int n) {
        if (n <= 0) {
            System.out.println("Numero non valido");
            return;
        }
        
        // Ciclo esterno per le righe
        for (int i = 1; i <= n; i++) {
            // Ciclo interno per gli asterischi
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); // Nuova riga
        }
    }
    
    /**
     * Stampa un triangolo di asterischi crescente con StringBuilder
     * @param n numero di righe del triangolo
     */
    public static void stampaTriangoloCresceStringBuilder(int n) {
        if (n <= 0) {
            System.out.println("Numero non valido");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= n; i++) {
            // Aggiungi asterischi per la riga corrente
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n"); // Nuova riga
        }
        
        System.out.print(sb.toString());
    }
    
    /**
     * Crea una stringa rappresentante il triangolo
     * @param n numero di righe del triangolo
     * @return stringa del triangolo
     */
    public static String creaTriangoloStringa(int n) {
        if (n <= 0) {
            return "";
        }
        
        StringBuilder risultato = new StringBuilder();
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                risultato.append("*");
            }
            if (i < n) { // Non aggiungere newline all'ultima riga
                risultato.append("\n");
            }
        }
        
        return risultato.toString();
    }
    
    /**
     * Stampa un triangolo di asterischi decrescente
     * @param n numero di righe del triangolo (partendo dal massimo)
     */
    public static void stampaTriangoloDecresce(int n) {
        if (n <= 0) {
            System.out.println("Numero non valido");
            return;
        }
        
        // Ciclo esterno per le righe
        for (int i = n; i >= 1; i--) {
            // Ciclo interno per gli asterischi
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); // Nuova riga
        }
    }
    
    /**
     * Stampa un triangolo di asterischi centrato (piramide)
     * @param n numero di righe del triangolo
     */
    public static void stampaTriangoloCentrato(int n) {
        if (n <= 0) {
            System.out.println("Numero non valido");
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            // Stampa spazi per centrare
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            
            // Stampa asterischi
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            
            System.out.println(); // Nuova riga
        }
    }
    
    /**
     * Stampa un triangolo rettangolo con carattere personalizzato
     * @param n numero di righe
     * @param carattere carattere da usare
     */
    public static void stampaTriangoloPersonalizzato(int n, char carattere) {
        if (n <= 0) {
            System.out.println("Numero non valido");
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(carattere);
            }
            System.out.println();
        }
    }
    
    /**
     * Stampa un triangolo con numeri invece di asterischi
     * @param n numero di righe del triangolo
     */
    public static void stampaTriangoloNumeri(int n) {
        if (n <= 0) {
            System.out.println("Numero non valido");
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
    /**
     * Conta il numero totale di asterischi in un triangolo
     * @param n numero di righe del triangolo
     * @return numero totale di asterischi
     */
    public static int contaAsterischi(int n) {
        if (n <= 0) {
            return 0;
        }
        
        // Formula: 1 + 2 + 3 + ... + n = n * (n + 1) / 2
        return n * (n + 1) / 2;
    }
    
    /**
     * Metodo di test con esempi predefiniti
     */
    public static void testConEsempiPredefiniti() {
        System.out.println("\n=== TEST CON ESEMPI PREDEFINITI ===");
        
        // Test con esempio fornito
        System.out.println("Esempio n = 5:");
        stampaTriangoloCresce(5);
        
        // Test con dimensioni diverse
        System.out.println("\nTriangolo n = 3:");
        stampaTriangoloCresce(3);
        
        System.out.println("\nTriangolo n = 7:");
        stampaTriangoloCresce(7);
        
        // Test triangolo decrescente
        System.out.println("\nTriangolo decrescente n = 4:");
        stampaTriangoloDecresce(4);
        
        // Test triangolo centrato (piramide)
        System.out.println("\nPiramide centrata n = 5:");
        stampaTriangoloCentrato(5);
        
        // Test con carattere personalizzato
        System.out.println("\nTriangolo con '#' n = 4:");
        stampaTriangoloPersonalizzato(4, '#');
        
        // Test con numeri
        System.out.println("\nTriangolo con numeri n = 5:");
        stampaTriangoloNumeri(5);
        
        // Test conteggio asterischi
        System.out.println("\nStatistiche:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Triangolo n=" + i + " ha " + contaAsterischi(i) + " asterischi");
        }
        
        // Test creazione stringa
        System.out.println("\nTriangolo come stringa (n=3):");
        String triangoloStringa = creaTriangoloStringa(3);
        System.out.println("'" + triangoloStringa + "'");
        
        // Test casi limite
        System.out.println("\nCasi limite:");
        System.out.println("n = 1:");
        stampaTriangoloCresce(1);
        
        System.out.println("n = 0 (dovrebbe dare errore):");
        stampaTriangoloCresce(0);
    }
}