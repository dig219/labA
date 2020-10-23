package clienti;


import java.util.Scanner;

/**
 * Clienti è la classe che contiene il metodo main dell'applicazione
 * in cui è gestito il menu principale
 * 
 * @author Manuel Nguyen & Digvijaysinh D. Raj
 */
public class Clienti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        
        Utente utente = new Utente();
        Login user = new Login();
        Registrazione reg = new Registrazione();
        
        int n = 1;
        
        String tmp = "1",scelta;
        
        while(tmp.equals("1")){
        System.out.println("-------MENU-------");
        System.out.println("1) Accesso libero ");
        System.out.println("2) Login          ");
        System.out.println("3) Registrazione  \n");
        
        System.out.print("Operazione desiderata: ");
        scelta = input.nextLine();
        
        switch(scelta){
            case "1":
                utente.accessoLibero(); /*menù accessibile a tutti*/
                break;
            case "2":
                user.userLoggato(); /* menù accessibile agli utenti loggati*/
                break;
            case "3":
                reg.registraCliente(); /*registrazione di nuovi utenti*/
                break;
            default:
                System.out.println("Selezione errata");
        }
            
            Scanner s = new Scanner(System.in);
            System.out.print("Premere 1 per ritornare al menu, altro per uscire : ");
            tmp = s.nextLine();
   
        }

    }

}
