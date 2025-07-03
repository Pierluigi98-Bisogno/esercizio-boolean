import java.util.Scanner;

public class Fattoriale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Chiedi il numero per il fattoriale
            System.out.print("Inserisci un numero per calcolare il fattoriale: ");
            int n = scanner.nextInt();
            
            // Verifica che il numero sia valido
            if (n < 0) {
                System.out.println("Errore: Il fattoriale non è definito per numeri negativi!");
                return;
            }
            
            // Calcola il fattoriale e costruisce la formula
            ResultatoFattoriale risultato = calcolaFattoriale(n);
            
            // Stampa il risultato nel formato richiesto
            System.out.println("\n" + risultato.formula + " = " + risultato.valore);
            
        } catch (Exception e) {
            System.out.println("Errore: Inserisci un numero valido!");
        } finally {
            scanner.close();
        }
    }
    
    // Classe per contenere il risultato del fattoriale
    static class ResultatoFattoriale {
        String formula;
        long valore;
        
        ResultatoFattoriale(String formula, long valore) {
            this.formula = formula;
            this.valore = valore;
        }
    }
    
    // Metodo per calcolare il fattoriale
    public static ResultatoFattoriale calcolaFattoriale(int n) {
        if (n == 0 || n == 1) {
            return new ResultatoFattoriale("1", 1);
        }
        
        long risultato = 1;
        StringBuilder formula = new StringBuilder();
        
        // Calcola il fattoriale e costruisce la formula
        for (int i = n; i >= 1; i--) {
            risultato *= i;
            if (formula.length() > 0) {
                formula.append("x");
            }
            formula.append(i);
        }
        
        return new ResultatoFattoriale(formula.toString(), risultato);
    }
}