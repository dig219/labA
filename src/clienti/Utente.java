package clienti;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La classe Utente gestisce tutte le funzionalità di un utente non loggato:
 * - Ricerca per: comune,tipologia e nome
 * 
 * @author Manuel Nguyen & Digvijaysinh D. Raj
 * 
 */
public class Utente {

    private String rist;

    /**
     * Inizializzo il costruttore vuoto dichiarando null rist
     */
    public Utente() {
        rist = null;
    }

    /**
     * Metodo che esegue la ricerca per comune
     * @param obj comune
     * @return ArrayList<String> contiene i ristoranti trovati
     */
    public ArrayList<String> ricercaComune(String obj) {

        ArrayList<String> lista = new ArrayList<String>();

        String str = "";
        String parti0[];
        String parti[];
        String parti2[];
        
        /* I:La Girola,via-Castegnate-21-Legnano-MI-20025,3465187762,www.lagirola.it,Italiano */
        try {
            FileReader file = new FileReader(".." + File.separator + "data" + File.separator + "EatAdvisor.dati");        
            BufferedReader daFile = new BufferedReader(file);
            while (str != null) {
                str = daFile.readLine();
                parti0 = str.split(":"); /*splitto la seconda aparte dopo i :*/
                if (parti0[0].equals("I")) { /*se è un inserimento */
                    parti = parti0[1].split(",");

                    parti2 = parti[1].split("-"); /*splitto l'indirizzo */

                    if (parti2[3].toLowerCase().equals(obj.toLowerCase()) || parti2[3].toLowerCase().contains(obj.toLowerCase())) { /*controllo comune*/
                        lista.add(str.substring(2, str.length())); /*aggiungo la riga nell'arraylist*/
                    }

                }
            }
            file.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (NullPointerException e) {
        }

        return lista;
    }

    /**
     * Metodo che esegue la ricerca per tipologia
     * @param obj tipologia (Italiano-Etnico-Fusion)
     * 
     * @return ArrayList<String> contiene i ristoranti trovati
     */
    public ArrayList<String> ricercaTipologia(String obj) {

        ArrayList<String> lista = new ArrayList<String>();

        String str = "";
        String parti0[];
        String parti[];
        /* I:La Girola,via-Castegnate-21-Legnano-MI-20025,3465187762,www.lagirola.it,Italiano */
        
        try {
            FileReader file = new FileReader(".." + File.separator + "data" + File.separator + "EatAdvisor.dati");
            BufferedReader daFile = new BufferedReader(file);
            while (str != null) {
                str = daFile.readLine();
                parti0 = str.split(":");  /*splitto la seconda aparte dopo i :*/
                if (parti0[0].equals("I")) { /*se è un inserimento */
                    parti = parti0[1].split(","); 
                    if (parti[4].equals(obj)) { /*se corrisponde con la tipologia*/
                        lista.add(str.substring(2, str.length())); /*aggiungo la riga nell'arraylist*/
                    }
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (NullPointerException e) {
        }

        return lista;
    }

    /**
     * Metodo che esegue la ricerca per nome
     * @param obj nome
     * @return ArrayList<String> contiene i ristoranti
     */
    public ArrayList<String> ricercaNome(String obj) {

        ArrayList<String> lista = new ArrayList<String>();
        String parti0[];
        String str = "";
        String parti[];
        
        /* I:La Girola,via-Castegnate-21-Legnano-MI-20025,3465187762,www.lagirola.it,Italiano */
        
        try {
            FileReader file = new FileReader(".." + File.separator + "data" + File.separator + "EatAdvisor.dati");
            BufferedReader daFile = new BufferedReader(file);
            while (str != null) {
                str = daFile.readLine();

                parti0 = str.split(":");  /*splitto la seconda aparte dopo i :*/
                if (parti0[0].equals("I")) { /*se è un inserimento */
                    parti = parti0[1].split(",");
                    if (parti[0].toLowerCase().equals(obj) || parti[0].toLowerCase().contains(obj)) { /*se corrisponde con il nome*/
                        lista.add(str.substring(2, str.length())); /*aggiungo la riga nell'arraylist*/
                    }
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (NullPointerException e) {
        }

        return lista;
    }

    /**
     * IL metodo gestisce tutte le funzionalità accessibili da chiunque
     */
    public void accessoLibero() {

        ArrayList<String> l = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        int scelta;
        String x;
        System.out.println("\n-------RICERCA-------");
        System.out.println("1) Comune");
        System.out.println("2) Tipologia");
        System.out.println("3) Nome");

        scelta = input.nextInt();

        switch (scelta) {
            case 1:
                System.out.print("Inserisci il comune: ");
                input.nextLine();
                x = input.nextLine();
                x = x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();

                l = ricercaComune(x); 
                if (l.size() == 0) {
                    System.out.println("Non presente");
                } else {
                    for (String obj : l) { /*itero tutti i ristorante trovati*/
                        System.out.println(splittaNome(obj));
                    }
                }
                break;
            case 2:
                System.out.print("Inserisci la tipologia: ");
                input.nextLine();
                x = input.nextLine();
                x = x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();

                l = ricercaTipologia(x);
                if (l.size() == 0) {
                    System.out.println("Non presente");
                } else {
                    for (String obj : l) {  /*itero tutti i ristorante trovati*/
                        System.out.println(splittaNome(obj));
                    }
                }

                break;
            case 3:
                System.out.print("Inserisci il nome: ");
                input.nextLine();
                x = input.nextLine();

                l = ricercaNome(x.toLowerCase());
                if (l.size() == 0) {
                    System.out.println("Non presente");
                } else {
                    for (String obj : l) {  /*itero tutti i ristorante trovati*/
                        System.out.println(splittaNome(obj));
                    }
                }
                break;
            default:
                System.out.println("Errore");
        }

        int pos;

        /*
        Se sono presenti ristoranti chiedo all'untente quale ristorante vuole 
        scegliere per vederne i suoi dettagli
        */
        if (l.size() > 0) {
            do {
                System.out.print("Quale ristorante selezionare (0 - " + (l.size() - 1) + ")?:");
                pos = input.nextInt();
            } while (pos < 0 || pos >= l.size()); /*la posizione deve corrispondere ai limiti estremi*/

            System.out.println();
            this.rist = l.get(pos); /* la stringa conterrò il ristorante relativo alla pos scelta*/
            selezionaRistorante(l, pos); /* richiama la funzione per vedere i dettagli */
        }
    }

    /**
     * Metodo che seleziona un ristorante
     * @param l arraylist contente tutti i ristoranti
     * @param x posizione scelta
     * 
     */
    public void selezionaRistorante(ArrayList<String> l, int x) {
        this.visualizzaInformazioni(l.get(x)); /* funzione che legge i dettagli di un ristorante*/

    }

    /**
     * Visualizza i dettagli del ristorante
     * @param rist ristorante scelto
     * 
     */
    public void visualizzaInformazioni(String rist) {
        
        String split[] = rist.split(",");
        ArrayList<String> listaGiudizi = this.leggiGiudizi(); /* salvo tutti i giudizi*/
        int[] arrayConta = new int[5];
        
        /*Stampo i dettagli del ristorante*/
        System.out.println("Nome: " + split[0]);
        System.out.println("Indirizzo:" + split[1]);
        System.out.println("Numero di telefono: " + split[2]);
        System.out.println("Sito web: " + split[3]);
        System.out.println("Tipologia: " + split[4]);

        /*Conteggio scala voti*/
        
        for(String y : listaGiudizi){
            if(Integer.parseInt(y.split("-")[1]) == 1)
                arrayConta[0]++;
            if(Integer.parseInt(y.split("-")[1]) == 2)
                arrayConta[1]++;
            if(Integer.parseInt(y.split("-")[1]) == 3)
                arrayConta[2]++;
            if(Integer.parseInt(y.split("-")[1]) == 4)
                arrayConta[3]++;
            if(Integer.parseInt(y.split("-")[1]) == 5)
                arrayConta[4]++;
        }
        
        /*Stampa scala voti*/
        System.out.println("\n\n---SCALA VOTI---\n");
        System.out.println("1 stella: " + arrayConta[0]);
        System.out.println("2 stelle: " + arrayConta[1]);
        System.out.println("3 stelle: " + arrayConta[2]);
        System.out.println("4 stelle: " + arrayConta[3]);
        System.out.println("5 stelle: " + arrayConta[4]);
        
        /*Stampa commenti*/
        System.out.println("\n\n---COMMENTI---");
        
        if(listaGiudizi.isEmpty()) /*se non ci sono commenti*/
            System.out.println("\nNon sono stati ancora inseriti commenti ");
        
        for (String x : listaGiudizi) {
            /*Stampo nickname e voto relativi al ristorante*/
            System.out.println("\nNickname: " + x.split("-")[0]);
            System.out.println("Voto: " + x.split("-")[1] );
            
            /*se è presente un commento*/
            if (!x.split("-")[2].equals("null")) {
                System.out.println("Commento: " + x.split("-")[2] + "\n");
            }
           
            System.out.println("----------------");

        }
        System.out.println();
    }

    /**
     * Metodo che legge tutti i giudizi inseriti dagli utenti
     * @return ArrayList<String> contenente i giudizi
     * 
     */
    public ArrayList<String> leggiGiudizi() {
        ArrayList<String> giud = new ArrayList<String>();
        String str = "";
        String parti0[], parti1[];

        try {
            FileReader file = new FileReader(".." + File.separator + "data" + File.separator + "EatAdvisor.dati");
            BufferedReader daFile = new BufferedReader(file);
            while (str != null) {
                str = daFile.readLine();

                parti0 = str.split(":");
                if (parti0[0].equals("G")) { /*se è un giudizio*/
                    parti1 = parti0[1].split(",");
                    if (parti1[1].equals(this.rist.split(",")[0])) { /* verifico nome rist*/
                        String giudizio = parti1[0] + "-" + parti1[3] + "-"; /* salvo nickname e voto*/

                        giudizio += parti1[4]; /*salvo commento*/
                        giud.add(giudizio); /*aggiungo il commento all'arraylist*/
                    }
                }

            }
            file.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (NullPointerException e) {
        }

        return giud;
    }

    /**
     * Metoto che estrae il nome dalla stringa
     * @param e
     * @return e.split(",")[0]
     * 
     */
    public String splittaNome(String e) {
        return e.split(",")[0];
    }

    /**
     * Metodo che ritorna i dati di uno specifico ristorante
     * @return String
     * 
     */
    public String getRist() {
        return rist;
    }

}
