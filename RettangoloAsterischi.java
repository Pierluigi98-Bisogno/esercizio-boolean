import java.util.Scanner;

public class RettangoloAsterischi {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Input del numero di righe
            System.out.print("Inserisci il numero di righe: ");
            int righe = scanner.nextInt();
            
            // Input del numero di colonne
            System.out.print("Inserisci il numero di colonne: ");
            int colonne = scanner.nextInt();
            
            // Validazione input
            if (righe <= 0 || colonne <= 0) {
                System.out.println("Errore: Il numero di righe e colonne deve essere positivo!");
                return;
            }
            
            // Stampa del rettangolo
            System.out.println("\nRettangolo " + righe + "x" + colonne + ":");
            stampaRettangolo(righe, colonne);
            
            // Informazioni aggiuntive
            System.out.println("\nTotale asterischi: " + (righe * colonne));
            
            // Test con esempi predefiniti
            System.out.println("\n--- Test con esempi predefiniti ---");
            testEsempi();
            
        } catch (Exception e) {
            System.out.println("Errore: Inserisci solo numeri interi validi!");
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Stampa un rettangolo pieno di asterischi
     * @param righe numero di righe del rettangolo
     * @param colonne numero di colonne del rettangolo
     */
    public static void stampaRettangolo(int righe, int colonne) {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                System.out.print("*");
            }
            System.out.println(); // Vai a capo dopo ogni riga
        }
    }
    
    /**
     * Stampa un rettangolo usando StringBuilder per migliori performance
     * @param righe numero di righe del rettangolo
     * @param colonne numero di colonne del rettangolo
     */
    public static void stampaRettangoloStringBuilder(int righe, int colonne) {
        StringBuilder sb = new StringBuilder();
        
        // Crea una riga di asterischi
        for (int j = 0; j < colonne; j++) {
            sb.append("*");
        }
        String riga = sb.toString();
        
        // Stampa tutte le righe
        for (int i = 0; i < righe; i++) {
            System.out.println(riga);
        }
    }
    
    /**
     * Stampa un rettangolo vuoto (solo bordi)
     * @param righe numero di righe del rettangolo
     * @param colonne numero di colonne del rettangolo
     */
    public static void stampaRettangoloVuoto(int righe, int colonne) {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                // Stampa asterisco solo sui bordi
                if (i == 0 || i == righe - 1 || j == 0 || j == colonne - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Stampa un rettangolo con carattere personalizzato
     * @param righe numero di righe del rettangolo
     * @param colonne numero di colonne del rettangolo
     * @param carattere carattere da utilizzare per il rettangolo
     */
    public static void stampaRettangoloPersonalizzato(int righe, int colonne, char carattere) {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                System.out.print(carattere);
            }
            System.out.println();
        }
    }
    
    /**
     * Stampa un rettangolo con numeri invece di asterischi
     * @param righe numero di righe del rettangolo
     * @param colonne numero di colonne del rettangolo
     */
    public static void stampaRettangoloNumeri(int righe, int colonne) {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                System.out.print((i * colonne + j + 1) % 10); // Numeri da 1 a 9, poi ricomincia
            }
            System.out.println();
        }
    }
    
    /**
     * Calcola l'area del rettangolo (numero totale di asterischi)
     * @param righe numero di righe del rettangolo
     * @param colonne numero di colonne del rettangolo
     * @return area del rettangolo
     */
    public static int calcolaArea(int righe, int colonne) {
        return righe * colonne;
    }
    
    /**
     * Calcola il perimetro del rettangolo
     * @param righe numero di righe del rettangolo
     * @param colonne numero di colonne del rettangolo
     * @return perimetro del rettangolo
     */
    public static int calcolaPerimetro(int righe, int colonne) {
        return 2 * (righe + colonne);
    }
    
    /**
     * Test con esempi predefiniti
     */
    public static void testEsempi() {
        System.out.println("\nEsempio 1: Rettangolo 4x6 (come richiesto)");
        stampaRettangolo(4, 6);
        
        System.out.println("\nEsempio 2: Rettangolo 3x8");
        stampaRettangolo(3, 8);
        
        System.out.println("\nEsempio 3: Quadrato 5x5");
        stampaRettangolo(5, 5);
        
        System.out.println("\nEsempio 4: Rettangolo vuoto 4x6");
        stampaRettangoloVuoto(4, 6);
        
        System.out.println("\nEsempio 5: Rettangolo personalizzato 3x5 con '#'");
        stampaRettangoloPersonalizzato(3, 5, '#');
        
        System.out.println("\nEsempio 6: Rettangolo con numeri 3x4");
        stampaRettangoloNumeri(3, 4);
        
        System.out.println("\nStatistiche per rettangolo 4x6:");
        System.out.println("Area: " + calcolaArea(4, 6));
        System.out.println("Perimetro: " + calcolaPerimetro(4, 6));
    }
}