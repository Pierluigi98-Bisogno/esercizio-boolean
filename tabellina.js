// Programma per stampare la tabellina di un numero
// Chiede all'utente il numero della tabellina e fino a quale numero arrivare

// Funzione per chiedere input all'utente
function chiediInput(messaggio) {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    
    return new Promise((resolve) => {
        rl.question(messaggio, (risposta) => {
            rl.close();
            resolve(parseInt(risposta));
        });
    });
}

// Funzione principale
async function main() {
    try {
        // Chiedi il numero della tabellina
        const numeroTabellina = await chiediInput('Inserisci il numero della tabellina: ');
        
        // Chiedi fino a quale numero arrivare
        const numeroFineTabellina = await chiediInput('Fino a quale numero vuoi arrivare? ');
        
        // Verifica che i numeri siano validi
        if (isNaN(numeroTabellina) || isNaN(numeroFineTabellina)) {
            console.log('Errore: Inserisci numeri validi!');
            return;
        }
        
        if (numeroFineTabellina < 0) {
            console.log('Errore: Il numero finale deve essere positivo!');
            return;
        }
        
        // Stampa la tabellina
        console.log(`\nTabellina del ${numeroTabellina} fino a ${numeroFineTabellina}:`);
        
        const risultati = [];
        for (let i = 0; i <= numeroFineTabellina; i++) {
            risultati.push(numeroTabellina * i);
        }
        
        // Stampa i risultati separati da virgola
        console.log(risultati.join(', '));
        
    } catch (error) {
        console.log('Errore durante l\'esecuzione:', error.message);
    }
}

// Esegui il programma
main();