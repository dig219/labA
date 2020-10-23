package ristoratori;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Ristorante è la classe che gestisce: - I dati relativi al ristorante tra cui:
 * - nomeRistorante 
 * - indirizzo 
 * - numeroTelefono 
 * - urlSito 
 * - tipologia
 *
 * In seguito provvede alla registrazione del ristorante su file
 *
 * @author Manuel Nguyen & Digvijaysinh D. Raj
 */
public class Ristorante {

    private String nomeRistorante;
    private Indirizzo indirizzo;
    private String numeroTelefono;
    private String urlSito;
    private Tipologia tipologia;

    /**
     * Costruttore vuoto per inizializzare l'oggetto dal metodo richiamante
     */
    public Ristorante() {
    }

    /**
     * Metodo che ritorna la stringa indicante il nome del ristorante
     *
     * @return nomeRistorante
     */
    public String getNomeRistorante() {
        return nomeRistorante;
    }

    /**
     * Il metodo inizializza l'attributo nomeRistorante
     *
     * @param nomeRistorante
     */
    public void setNomeRistorante(String nomeRistorante) {
        this.nomeRistorante = nomeRistorante;
    }

    /**
     * Metodo che ritorna l'oggetto Indirizzo
     *
     * @return indirizzo
     */
    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    /**
     * Il metodo inizializza l'oggetto Indirizzo
     *
     * @param indirizzo
     */
    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * Metodo che ritorna la stringa indicante il numero del ristorante
     *
     * @return numeroTelefono
     */
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * Il metodo inizializza l'attributo numeroTelefono
     *
     * @param numeroTelefono
     */
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * Metodo che ritorna la stringa indicante il sito web del sito
     *
     * @return urlSito
     */
    public String getUrlSito() {
        return urlSito;
    }

    /**
     * Il metodo inizializza l'attributo urlSito
     *
     * @param urlSito
     */
    public void setUrlSito(String urlSito) {
        this.urlSito = urlSito;
    }

    /**
     * Metodo che ritorna l'oggetto Tipologia che contiene la tipologia del
     * ristorante
     *
     * @return tipologia
     */
    public Tipologia getTipologia() {
        return tipologia;
    }

    /**
     * Il metodo inizializza l'oggetto Tipologia
     *
     * @param tipologia
     */
    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }

    /**
     * Metodo che ritorna tutti la stringa contente i dati relativi al
     * ristorante
     *
     * @return nomeRistorante + "," + indirizzo.toString() + "," +
     * numeroTelefono + "," + urlSito + "," + tipologia.toString();
     */
    @Override
    public String toString() {
        return nomeRistorante + "," + indirizzo.toString() + "," + numeroTelefono + "," + urlSito + "," + tipologia.toString();
    }

    /**
     * Tale metodo chiede in input tutti i dati relativi al ristorante, fino
     * a quando non vengono rispettati i controlli sui dati, riportandoli
     * in seguito sul file EatAdvisor.dati 
     */
    public void registraRistorante() {
        Scanner tastiera = new Scanner(System.in); 

        /*
        Chiedo il nome del ristorante fino a quando:
        - Inserimento vuoto
        - Stringa che contiene ',' o ':'
        */
        System.out.print("Inserisci il nome del ristorante: ");
        this.nomeRistorante = tastiera.nextLine();
        while (this.nomeRistorante.equals("") || this.nomeRistorante.contains(",") || this.nomeRistorante.contains(":")) {
            System.out.print("Errore, formato non valido...digitare nuovamente: ");
            this.nomeRistorante = tastiera.nextLine();
        }

        /*
        Chiedo l'acquisizione dell'indirizzo e per quanto riguarda il qualificatore,
        continuo a chiedere fino a quando è diverso da:
        - Via
        - Viale
        - corso
        - piazza 
        - piazzale
        */
        System.out.println("Inserisci l'indirizzo(qualificatore, nome, numero civico, comune, sigla della provincia, CAP)");
        System.out.print("Inserisci il qualificatore: ");
        String qualificatore = tastiera.nextLine();
        qualificatore = qualificatore.toLowerCase();
        while ((!qualificatore.equals("via")) && (!qualificatore.equals("viale")) && (!qualificatore.equals("corso")) && (!qualificatore.equals("piazza")) && (!qualificatore.equals("piazzale"))) {
            System.out.print("Errore, formato non valido...digitare nuovamente: ");
            qualificatore = tastiera.nextLine();
            qualificatore = qualificatore.toLowerCase();
        }

        System.out.print("Inserisci il nome: ");
        String nome = tastiera.nextLine();
        while (nome.equals("")) { /*fino a quando la stringa è vuota, ripeto*/
            System.out.print("Errore, formato non valido...digitare nuovamente: ");
            nome = tastiera.nextLine();
        }
        /*
        Esempio formato
        vArEsE -> Varese
        */
        
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        System.out.print("Inserisci il numero civico: ");
        String numCivico = tastiera.nextLine();
        while (numCivico.equals("")) { /*fino a quando la stringa è vuota, ripeto*/
            System.out.print("Errore, formato non valido...digitare nuovamente: ");
            numCivico = tastiera.nextLine();
        }

        System.out.print("Inserisci il comune: ");
        String comune = tastiera.nextLine();
        while (comune.equals("")) { /*fino a quando la stringa è vuota, ripeto*/
            System.out.print("Errore, formato non valido...digitare nuovamente: ");
            comune = tastiera.nextLine();
        }
        comune = comune.substring(0, 1).toUpperCase() + comune.substring(1).toLowerCase();

        System.out.print("Inserisci la sigla della provincia: ");;
        String siglaProvincia = tastiera.nextLine();
        siglaProvincia = siglaProvincia.toUpperCase(); /*maiuscola*/
        while (isNumeric(siglaProvincia) || siglaProvincia.length() != 2) { /*chiedo fino a quando non sono inseriti 2 caratteri*/
            System.out.print("Errore, formato non valido...digitare nuovamente: ");
            siglaProvincia = tastiera.nextLine();
            siglaProvincia = siglaProvincia.toUpperCase(); /*maiuscola*/
        }

        System.out.print("Inserisci il cap: ");
        String cap = tastiera.nextLine();
        while (!(isNumeric(cap)) || cap.length() != 5) { /*se il cap non è numero o non contiene 5 numeri*/
            System.out.print("Errore, formato non valido...digitare nuovamente: ");
            cap = tastiera.nextLine();
        }

        this.indirizzo = new Indirizzo(qualificatore, nome, numCivico, comune, siglaProvincia, cap); /*creo l'oggetto indirizzo*/

        System.out.print("Inserisci il numero di telefono(senza preferisso):  ");
        this.numeroTelefono = tastiera.nextLine();
        
        /*
        Chiedo il numero di telefono fino a quando:
        - Non contiene solo cifre numeriche
        - Ha lunghezza minore di 6
        - Ha lunghezza maggiore di 11
        */
        while (!(isNumeric(this.numeroTelefono)) || (this.numeroTelefono.length() < 6 || this.numeroTelefono.length() > 11)) {
            System.out.print("Errore, formato non valido...digitare nuovamente: ");
            this.numeroTelefono = tastiera.nextLine();
        }

        System.out.print("Inserisci il url sito: ");
        this.urlSito = tastiera.nextLine();
        while (this.urlSito.equals("")) { /*fno a quando l'inserimento è vuoto*/
            System.out.print("Errore, formato non valido...digitare nuovamente: ");
            this.urlSito = tastiera.nextLine();
        }

        System.out.print("Inserisci la tipologia(Italiano-Etnico-Fusion): ");
        String tipo = tastiera.nextLine();
        tipo = tipo.toLowerCase();
        /*
        Chiedo la tipologia fino a quando un utente non scrive correttamente:
        - Italiano / italiano
        - Etnico / etnico
        - Fusion / fusion
        */
        while ((!tipo.equals("italiano")) && (!tipo.equals("etnico")) && (!tipo.equals("fusion"))) {
            System.out.print("Errore, formato non valido...digitare nuovamente: ");
            tipo = tastiera.nextLine();
            tipo = tipo.toLowerCase();
        }
        /*
        Esempio formato
        ItALIanO -> Italiano
        */
        tipo = tipo.substring(0, 1).toUpperCase() + tipo.substring(1).toLowerCase();

        this.tipologia = new Tipologia(tipo); /*creo l'oggetto tipologia*/

        if (!checkRistorante()) { /*se il ristorante non è già stato registrato*/
            scriviFile(); /*scrivo su file */
        } else {
            System.out.println("Ristorante già registrato!");
        }
    }

    /**
     * Metodo che controlla che il parametro sia un numero 
     * 
     * @param strNum
     * @exception NumberFormatException
     * @return true se è un numero
     */
    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Tale metodo controlla che non sia già registrato un ristorante già presente
     * nomi uguali e indirizzi uguali -> segnalo un errore
     * nome uguali e indirizzi diversi -> effettuo la registrazione
     * 
     * @exception IOException se c'è un errore relativo all'apertura / scrittura
     * @exception NullPointerException puntatore nullo al file
     * @exception FileNotFoundException file non trovato
     * @return true se è già presente il ristorante nel file
     */
    public Boolean checkRistorante() {
        String str = "";
        /*Array per le split*/
        String parti0[]; /*contiene I */
        String parti[]; /* splitto I dentro*/
        
        try {
            FileReader file = new FileReader(".." + File.separator + "data" + File.separator + "EatAdvisor.dati");
            
            BufferedReader daFile = new BufferedReader(file);
            while (str != null) {
                
                str = daFile.readLine();
                
                if(str != null){
                    parti0 = str.split(":"); /*splitto sui due punti*/   
                    if (parti0[0].equals("I")) { /*se è un inserimento (I)*/
                        parti = parti0[1].split(","); /* splitto la seconda parte con ,*/

                        /*se nome e indirizzo sono uguali vuol dire che è già presente un ristoranre con stesso nome e indirizzo*/
                        if (parti[0].toLowerCase().equals(this.nomeRistorante.toLowerCase()) && parti[1].toLowerCase().equals(this.indirizzo.toString().toLowerCase())) {
                            return true;
                            }
                        }
                    }
                }
            file.close();
        } catch (FileNotFoundException e) {
            System.err.format("FileNotFoundException: %s%n", e);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } catch (NullPointerException e) {
            System.err.format("NullPointerException: %s%n", e);
        }
        return false;
    }

    /**
     * Tale funzione scrive su file tutti i dati relativi del ristorante
     *
     * @exception IOException se c'è un errore relativo all'apertura / scrittura
     */
    public void scriviFile() {
        File f = new File(".." + File.separator + "data" + File.separator + "EatAdvisor.dati");

        try {
            FileWriter writer = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write("I:" + toString()); 
            /*
            I: sta per inserimento, su file verrà riportata la I: + dati relativi,
            per differenziare l'inserimento di un ristorante da un giudizio
            */
            bw.newLine();
            bw.close();

            System.out.println("Ristorante " + this.nomeRistorante + " registrato!");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }

}
