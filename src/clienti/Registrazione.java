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
 * La classe Registrazione permette, una volta chiesti in input i dati,
 * di registrare l'utente su file qual'ora non fosse già registrato
 * 
 * 
 * @author Manuel Nguyen & Digvijaysinh D. Raj
 */
public class Registrazione {
    private String nome;
    private String cognome;
    private String comuneResidenza;
    private String siglaProvincia;
    private String email;
    private String nickname;
    private String password;

    /**
     * Inizializzo il costruttore vuoto
     */
    public Registrazione() {
    }

    /**
     * Funzione che ritorna il nome utente
     * @return nome
     * 
     */
    public String getNome() {
        return nome;
    }

    /**
     * Funzione che ritorna il cognome dell' utente
     * @return cognome
     * 
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Funzione che ritorna il comune di residenza dell' utente
     * @return comuneResidenza
     * 
     */
    public String getComuneDiResidenza() {
        return comuneResidenza;
    }

    /**
     * Funzione che ritorna la provincia
     * @return siglaProvincia
     * 
     */
    public String getSiglaProvincia() {
        return siglaProvincia;
    }

    /**
     * Funzione che ritorna l'email dell'utente
     * @return email
     * 
     */
    public String getEmail() {
        return email;
    }

    /**
     * Funzione che ritorna il nickanme
     * @return nickname
     * 
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Funzione che ritorna la password
     * @return password
     * 
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Metodo che chiede in input i dati dell'utente e registra su file 
     * operando gli oppurtuni controlli
     * 
     */
    public void registraCliente() {
        Scanner tastiera = new Scanner(System.in);
        
        /*
        Chiedo in input il nome della persona fino a quando non
        è vuoto
        */
        do {
            System.out.print("Inserisci il nome: ");
            this.nome = tastiera.nextLine();
            if (this.nome.equals("")) { 
                System.out.println("Errore, formato non valido...digitare nuovamente");
            }
        } while (this.nome.equals(""));
        this.nome = this.nome.substring(0, 1).toUpperCase() + this.nome.substring(1).toLowerCase();
        
        /*
        Chiedo in input il cognome della persona fino a quando non
        è vuoto
        */
        do {
            System.out.print("Inserisci il cognome: ");
            this.cognome = tastiera.nextLine();
            if (this.cognome.equals("")) {
                System.out.println("Errore, formato non valido...digitare nuovamente");
            }
        } while (this.cognome.equals(""));
        this.cognome = this.cognome.substring(0, 1).toUpperCase() + this.cognome.substring(1).toLowerCase();
        
        /*
        Chiedo in input il comune di residenza fino  a quando non
        è vuoto
        */
        do {
            System.out.print("Inserisci il comune di residenza: ");
            this.comuneResidenza = tastiera.nextLine();
            if (this.comuneResidenza.equals("")) {
                System.out.println("Errore, formato non valido...digitare nuovamente");
            }
        } while (this.comuneResidenza.equals(""));
        this.comuneResidenza = this.comuneResidenza.substring(0, 1).toUpperCase() + this.comuneResidenza.substring(1).toLowerCase();

        /*
        Chiedo la sigla della provincia fino a quando non sono stati inseriti
        solo 2 caratteri
        */
        do {
            System.out.print("Inserisci la sigla della Provincia: ");
            this.siglaProvincia = tastiera.nextLine();
            this.siglaProvincia = this.siglaProvincia.toUpperCase();
            if (this.siglaProvincia.length() != 2) {
                System.out.println("Errore, formato non valido...digitare nuovamente");
            }
        } while (this.siglaProvincia.length() != 2);

        boolean x = false;

        /*
        Chiedo l'email fino a quando non è stata inserita un'email corretta
        controllando tramite la funzione isValideEmailAddredd(String str)
        Eseguo anche in controllo che non sia già stata utilizzata
        */
        do {
            //x = false;
            System.out.print("Inserisci l'email: ");
            this.email = tastiera.nextLine();
            if (!isValidEmailAddress(this.email)) {
                System.out.println("Errore, formato non valido...digitare nuovamente");
            } else {
                if (check(this.email, 4)) {
                    System.out.println("Email già utilizzata");
                }
            }

        } while (!isValidEmailAddress(this.email) || check(this.email, 4));

        x = false;
        
        /*
        Chiedo l'user fino a quando non è stato inserito un user non vuoto e inoltre
        controllo pure che non sia già stato utilizzato
        */
        do {
            System.out.print("Inserisci il nickname: ");
            this.nickname = tastiera.nextLine();
            if (!check(this.nickname, 5) && !this.nickname.equals("")) {
                x = true;
            }
            if (!x) {
                System.out.println("Nickname già utilizzato...digitare nuovamente");
            }
            if (this.nickname.equals("")) {
                System.out.println("Errore, formato non valido...digitare nuovamente");
            }

        } while (!x || this.nickname.equals(""));

        /*
        Chiedo la password che deve avere almeno una lunghezza di 8 char
        */
        do {
            System.out.print("Inserisci la password (8 caratteri minimo): ");
            this.password = tastiera.nextLine();
            if (this.password.length() < 8) {
                System.out.println("Errore, formato non valido...digitare nuovamente");
            }
        } while (this.password.length() < 8);

        scriviFile(); /*riporto tutti i dati su file*/
        
    }

    /**
     * Tale funzione riporta tutti i dati registrati sul file
     */
    public  void scriviFile(){
       File f = new File(".." + File.separator + "data" + File.separator + "Utenti.dati");
       
       
        try (FileWriter writer = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(writer)) {
            /*Marco,Boltelli,Firenze,FI,marco.boltelli@hotmail.it,marco,cancellone23*/
            bw.write(this.toString());
            bw.newLine();
            bw.close();
            
            System.out.println("\nUtente " + this.nickname + " registrato"); /*conferma registrazione*/
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    
    /**
     * Check controlla che cosa deve essere controllato e la sua posizione nella riga
     * splittata da ',' nel file
     * 
     * Controllo su nickname,email
     * @param nickname da controllare
     * @param parametro posizione da controllare
     * @return boolean true se è già stato registrato
     */
    public boolean check(String nickname, int parametro) {
        if (parametro < 4 || parametro > 6) {
            return false;
        }
        String str = "";
        String parti[];
        try {
            FileReader file = new FileReader(".." + File.separator + "data" + File.separator + "Utenti.dati");
            BufferedReader daFile = new BufferedReader(file);
            while (str != null) {
                str = daFile.readLine();
                parti = str.split(",");
                if (parti[parametro].equals(nickname)) { /*in base a parametro e nickname controlla che non ci siano già */
                    return true;
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
     *  Metodo che controlla se un indirzzo mail è valido
     * 
     * @param email
     * @return boolean true se l'indirizzo è valido
     * 
     */
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(this.email);
        return m.matches();
    }
     
    /**
     * Metodo toString() della classe che riporta tutti i dati con una ','
     * 
     * @return nome,cognome,comuneRedisenza,siglaProvincia,email,nickname,password
     */
    @Override
    public String toString() {
        return   this.nome + "," + this.cognome + "," + this.comuneResidenza + "," + this.siglaProvincia + "," + this.email + "," + this.nickname + "," + this.password;
    }
}
