import java.util.Scanner;

public class InvertiStringa {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Input della stringa
            System.out.print("Inserisci una stringa: ");
            String stringaOriginale = scanner.nextLine();
            
            // Inversione della stringa
            String stringaInvertita = invertiStringa(stringaOriginale);
            
            // Output del risultato
            System.out.println("Stringa originale: " + stringaOriginale);
            System.out.println("Output: " + stringaInvertita);
            
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        } finally {
            scanner.close();
        }
        
        // Test con stringhe predefinite (commentato per default)
        // testConStringhePredefinite();
    }
    
    /**
     * Inverte una stringa utilizzando StringBuilder
     * @param stringa la stringa da invertire
     * @return la stringa invertita
     */
    public static String invertiStringa(String stringa) {
        if (stringa == null) {
            return null;
        }
        
        if (stringa.isEmpty()) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder(stringa);
        return sb.reverse().toString();
    }
    
    /**
     * Inverte una stringa utilizzando un ciclo for
     * @param stringa la stringa da invertire
     * @return la stringa invertita
     */
    public static String invertiStringaConCiclo(String stringa) {
        if (stringa == null) {
            return null;
        }
        
        if (stringa.isEmpty()) {
            return "";
        }
        
        StringBuilder risultato = new StringBuilder();
        
        // Scorre la stringa dal fondo verso l'inizio
        for (int i = stringa.length() - 1; i >= 0; i--) {
            risultato.append(stringa.charAt(i));
        }
        
        return risultato.toString();
    }
    
    /**
     * Inverte una stringa utilizzando la ricorsione
     * @param stringa la stringa da invertire
     * @return la stringa invertita
     */
    public static String invertiStringaRicorsiva(String stringa) {
        if (stringa == null) {
            return null;
        }
        
        if (stringa.length() <= 1) {
            return stringa;
        }
        
        // Ricorsione: ultimo carattere + inversione del resto
        return stringa.charAt(stringa.length() - 1) + 
               invertiStringaRicorsiva(stringa.substring(0, stringa.length() - 1));
    }
    
    /**
     * Inverte una stringa convertendola in array di caratteri
     * @param stringa la stringa da invertire
     * @return la stringa invertita
     */
    public static String invertiStringaConArray(String stringa) {
        if (stringa == null) {
            return null;
        }
        
        if (stringa.isEmpty()) {
            return "";
        }
        
        char[] caratteri = stringa.toCharArray();
        int inizio = 0;
        int fine = caratteri.length - 1;
        
        // Scambia i caratteri dalle estremità verso il centro
        while (inizio < fine) {
            char temp = caratteri[inizio];
            caratteri[inizio] = caratteri[fine];
            caratteri[fine] = temp;
            
            inizio++;
            fine--;
        }
        
        return new String(caratteri);
    }
    
    /**
     * Stampa una stringa carattere per carattere in ordine inverso
     * @param stringa la stringa da stampare
     */
    public static void stampaStringaInversa(String stringa) {
        if (stringa == null) {
            System.out.print("null");
            return;
        }
        
        if (stringa.isEmpty()) {
            System.out.print("(stringa vuota)");
            return;
        }
        
        for (int i = stringa.length() - 1; i >= 0; i--) {
            System.out.print(stringa.charAt(i));
        }
    }
    
    /**
     * Metodo di test con stringhe predefinite
     */
    public static void testConStringhePredefinite() {
        System.out.println("\n=== TEST CON STRINGHE PREDEFINITE ===");
        
        // Test con esempio fornito
        String esempio = "Ciao";
        System.out.println("Esempio: " + esempio);
        System.out.println("Output: " + invertiStringa(esempio));
        
        // Test con diversi metodi
        System.out.println("\n=== CONFRONTO METODI ===");
        String test = "Hello World";
        System.out.println("Stringa originale: " + test);
        System.out.println("StringBuilder: " + invertiStringa(test));
        System.out.println("Ciclo for: " + invertiStringaConCiclo(test));
        System.out.println("Ricorsione: " + invertiStringaRicorsiva(test));
        System.out.println("Array swap: " + invertiStringaConArray(test));
        
        // Test con casi speciali
        System.out.println("\n=== CASI SPECIALI ===");
        System.out.println("Stringa vuota: '" + invertiStringa("") + "'");
        System.out.println("Un carattere: '" + invertiStringa("A") + "'");
        System.out.println("Palindromo: '" + invertiStringa("radar") + "'");
        System.out.println("Con spazi: '" + invertiStringa("a b c") + "'");
        System.out.println("Con numeri: '" + invertiStringa("123456") + "'");
        
        // Test stampa diretta
        System.out.println("\n=== STAMPA DIRETTA ===");
        System.out.print("Stampa inversa di 'Java': ");
        stampaStringaInversa("Java");
        System.out.println();
    }
}