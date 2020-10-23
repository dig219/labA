package clienti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * La classe Login permette di gestire tutte le funzionalità
 * extra riservate agli utenti registrati e estende la casse utente ereditandone
 * i metodi e attributi principali
 * 
 * @author Manuel Nguyen & Digvijaysinh D. Raj
 */
public class Login extends Utente {

    private String user;

    /**
     * Inizializzo il costruttore vuoto richiamando super che a sua volta
     * richiama il costruttore padre
     * 
     */
    public Login() {
        super();
    }

    /**
     * Il metodo login gestisce l'autenticazione dell'utente 
     * 
     * @return Boolean true se è loggato
     */
    public Boolean login() {
        Scanner input = new Scanner(System.in);

        System.out.print("Nickname: ");
        String nome = input.nextLine();
        System.out.print("Password:");
        String password = input.nextLine();

        String str = "";
        String parti[];
        
        /*
        Leggo riga per riga e se il nome sul file corrisponde al nome chiesto in
        input, esegue un controllo sulla password del file
        
        Se non è presente l'user -> false
        Utente e/o password sbagliati -> false
        
        */
        try {
            FileReader file = new FileReader(".." + File.separator + "data" + File.separator + "Utenti.dati");
            BufferedReader daFile = new BufferedReader(file);
            while (str != null) {
                str = daFile.readLine();
                parti = str.split(",");

                if (parti[5].equals(nome)) {
                    if (parti[6].equals(password)) {
                        this.user = parti[5];
                        return true;
                    }
                }

            }
            file.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (NullPointerException e) {
        }

        return false;
    }

    /**
     * Il metodo giudica permette all'utente loggato di esprimere un giudizio
     * su un ristorante tramite:
     * - Voto da 1 a 5
     * - Commento (opzionale)
     * 
     * 
     */
    public void giudica() {
        if(this.getRist() != null){
        
        Scanner input = new Scanner(System.in);
        int stelline = 0;
        String n,commento;

        System.out.print("Vuoi scrivere un giudizio (1 per confermare) ?");
        n = input.nextLine();


        if (n.equals("1")) { /*Se l'utente preme 1 -> vuole commentare*/

            do {
                System.out.print("Inserisci le stelline da 1 a 5: ");
                stelline = input.nextInt();
            } while (stelline <= 0 || stelline > 5); /*controllo voto da 1 a 5*/

            input.nextLine();

            System.out.print("Vuoi inserire un commento (1 per confermare) ?");
            n = input.nextLine(); /*Chiedo se vuole inserire un commento*/
            //input.nextLine();
            
            if (n.equals("1")) { /*se vuole inserire un commento*/
                do {

                    System.out.print("Inserisci il commento: ");
                    commento = input.nextLine(); /*chiedo il commento*/
                    
                    if(commento.length() <= 0) 
                        System.out.println("Errore, formato non valido...digitare nuovamente");
                    if(commento.length()>256)
                        System.out.println("Commento troppo lungo... digitare nuovamente");
                } while (commento.length() <= 0 || commento.length()>256); /*doppio check*/
            }
            else
                commento = "null"; /*se non vuole inserire il commento, scrive null su file*/
                
            
            
            this.scriviFile(stelline, commento.trim(), this.getRist()); /*riporto su file*/
        }
        }
    }
    
    /**
     * La seguente funzione permette di riportare voto e commento su file
     * 
     * @param stelline 
     * @param commento 
     * @param rist nome ristorante
     */
     private void scriviFile(int stelline, String commento, String rist){
       File f = new File(".." + File.separator + "data" + File.separator + "EatAdvisor.dati");
       String parti[] = rist.split(",");
       
        try {
            FileWriter writer = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(writer);
            /*
            Es
            G:marco,La Girola,via-Castegnate-21-Legnano-MI-20025,4,null
            */
            bw.write("G:" + this.user + "," + parti[0] + "," + parti[1] + "," + stelline + ","+ commento);
            bw.newLine();
            bw.close();     
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    /**
     * La funzione permette di loggare, ricercare e/o giudicare
     */
    public void userLoggato() {

        if (this.login()) { /*se l'utente è loggato*/
            System.out.println("Loggato");

            this.accessoLibero();

            this.giudica();
        } else {
            System.out.println("Nickname o Password non corretti");
        }

    }
}
