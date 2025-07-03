import java.util.Scanner;

public class Tabellina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Chiedi il numero della tabellina
            System.out.print("Inserisci il numero della tabellina: ");
            int numeroTabellina = scanner.nextInt();
            
            // Chiedi fino a quale numero arrivare
            System.out.print("Fino a quale numero vuoi arrivare? ");
            int numeroFineTabellina = scanner.nextInt();
            
            // Verifica che il numero finale sia positivo
            if (numeroFineTabellina < 0) {
                System.out.println("Errore: Il numero finale deve essere positivo!");
                return;
            }
            
            // Stampa la tabellina
            System.out.println("\nTabellina del " + numeroTabellina + " fino a " + numeroFineTabellina + ":");
            
            // Calcola e stampa i risultati
            StringBuilder risultati = new StringBuilder();
            for (int i = 0; i <= numeroFineTabellina; i++) {
                if (i > 0) {
                    risultati.append(", ");
                }
                risultati.append(numeroTabellina * i);
            }
            
            System.out.println(risultati.toString());
            
        } catch (Exception e) {
            System.out.println("Errore: Inserisci numeri validi!");
        } finally {
            scanner.close();
        }
    }
}