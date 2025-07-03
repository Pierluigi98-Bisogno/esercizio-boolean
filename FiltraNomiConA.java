import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FiltraNomiConA {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Input del numero di nomi
            System.out.print("Inserisci il numero di nomi: ");
            int numeroNomi = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline
            
            // Validazione del numero
            if (numeroNomi <= 0) {
                System.out.println("Errore: Il numero deve essere positivo.");
                return;
            }
            
            // Creazione e popolamento dell'array
            String[] nomi = new String[numeroNomi];
            System.out.println("Inserisci i nomi:");
            
            for (int i = 0; i < numeroNomi; i++) {
                System.out.print("Nome " + (i + 1) + ": ");
                nomi[i] = scanner.nextLine().trim();
            }
            
            // Filtraggio e stampa dei nomi che iniziano con 'A'
            System.out.println();
            System.out.println("Array completo: " + arrayToString(nomi));
            System.out.print("Output: ");
            stampaNomiConA(nomi);
            System.out.println();
            
            // Mostra anche la lista filtrata
            List<String> nomiFiltrati = filtraNomiConA(nomi);
            System.out.println("Nomi che iniziano con 'A': " + nomiFiltrati);
            
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        } finally {
            scanner.close();
        }
        
        // Test con array predefinito (commentato per default)
        // testConArrayPredefinito();
    }
    
    /**
     * Stampa i nomi che iniziano con 'A' separati da virgola
     * @param nomi array di nomi
     */
    public static void stampaNomiConA(String[] nomi) {
        if (nomi == null || nomi.length == 0) {
            System.out.print("Nessun nome trovato");
            return;
        }
        
        boolean primo = true;
        
        for (String nome : nomi) {
            if (nome != null && !nome.isEmpty() && 
                (nome.charAt(0) == 'A' || nome.charAt(0) == 'a')) {
                
                if (!primo) {
                    System.out.print(", ");
                }
                System.out.print(nome);
                primo = false;
            }
        }
        
        if (primo) {
            System.out.print("Nessun nome inizia con 'A'");
        }
    }
    
    /**
     * Filtra i nomi che iniziano con 'A' e li restituisce in una lista
     * @param nomi array di nomi
     * @return lista dei nomi che iniziano con 'A'
     */
    public static List<String> filtraNomiConA(String[] nomi) {
        List<String> risultato = new ArrayList<>();
        
        if (nomi == null) {
            return risultato;
        }
        
        for (String nome : nomi) {
            if (nome != null && !nome.isEmpty() && 
                (nome.charAt(0) == 'A' || nome.charAt(0) == 'a')) {
                risultato.add(nome);
            }
        }
        
        return risultato;
    }
    
    /**
     * Conta quanti nomi iniziano con 'A'
     * @param nomi array di nomi
     * @return numero di nomi che iniziano con 'A'
     */
    public static int contaNomiConA(String[] nomi) {
        if (nomi == null) {
            return 0;
        }
        
        int contatore = 0;
        
        for (String nome : nomi) {
            if (nome != null && !nome.isEmpty() && 
                (nome.charAt(0) == 'A' || nome.charAt(0) == 'a')) {
                contatore++;
            }
        }
        
        return contatore;
    }
    
    /**
     * Verifica se un nome inizia con una lettera specifica (case-insensitive)
     * @param nome il nome da verificare
     * @param lettera la lettera da cercare
     * @return true se il nome inizia con la lettera specificata
     */
    public static boolean iniziaConLettera(String nome, char lettera) {
        if (nome == null || nome.isEmpty()) {
            return false;
        }
        
        char primoCarattere = Character.toLowerCase(nome.charAt(0));
        char letteraTarget = Character.toLowerCase(lettera);
        
        return primoCarattere == letteraTarget;
    }
    
    /**
     * Filtra i nomi che iniziano con una lettera specifica
     * @param nomi array di nomi
     * @param lettera la lettera da cercare
     * @return lista dei nomi che iniziano con la lettera specificata
     */
    public static List<String> filtraNomiConLettera(String[] nomi, char lettera) {
        List<String> risultato = new ArrayList<>();
        
        if (nomi == null) {
            return risultato;
        }
        
        for (String nome : nomi) {
            if (iniziaConLettera(nome, lettera)) {
                risultato.add(nome);
            }
        }
        
        return risultato;
    }
    
    /**
     * Converte un array di stringhe in una stringa formattata
     * @param array l'array da convertire
     * @return la rappresentazione in stringa dell'array
     */
    public static String arrayToString(String[] array) {
        if (array == null || array.length == 0) {
            return "{}";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        
        for (int i = 0; i < array.length; i++) {
            sb.append('"').append(array[i]).append('"');
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
        
        // Test con esempio fornito
        String[] nomiEsempio = {"Anna", "Luca", "Alberto", "Giulia", "Andrea"};
        System.out.println("Array esempio: " + arrayToString(nomiEsempio));
        System.out.print("Output: ");
        stampaNomiConA(nomiEsempio);
        System.out.println();
        
        // Test con diversi casi
        System.out.println("\n=== TEST AGGIUNTIVI ===");
        
        String[] nomiTest1 = {"antonio", "ALESSANDRO", "marco", "alice"};
        System.out.println("Test case-insensitive: " + arrayToString(nomiTest1));
        System.out.print("Nomi con 'A': ");
        stampaNomiConA(nomiTest1);
        System.out.println();
        
        String[] nomiTest2 = {"Bruno", "Carlo", "Davide"};
        System.out.println("\nNessun nome con 'A': " + arrayToString(nomiTest2));
        System.out.print("Nomi con 'A': ");
        stampaNomiConA(nomiTest2);
        System.out.println();
        
        String[] nomiTest3 = {"Ada", "Aldo", "Amelia", "Arturo"};
        System.out.println("\nTutti con 'A': " + arrayToString(nomiTest3));
        System.out.print("Nomi con 'A': ");
        stampaNomiConA(nomiTest3);
        System.out.println();
        
        // Test con metodi aggiuntivi
        System.out.println("\n=== STATISTICHE ===");
        System.out.println("Conteggio nomi con 'A' nell'esempio: " + contaNomiConA(nomiEsempio));
        
        // Test filtro generico
        System.out.println("\n=== FILTRO GENERICO ===");
        List<String> nomiConG = filtraNomiConLettera(nomiEsempio, 'G');
        System.out.println("Nomi che iniziano con 'G': " + nomiConG);
        
        List<String> nomiConL = filtraNomiConLettera(nomiEsempio, 'L');
        System.out.println("Nomi che iniziano con 'L': " + nomiConL);
    }
}