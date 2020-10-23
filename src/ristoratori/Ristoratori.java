/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristoratori;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ristoratori è la classe che crea una nuova istanza della classe Ristorante e
 * avvia il metodo registraRistorante() che permette di registrare un nuovo
 * ristorante salvandolo su un file con estensione .dati
 *
 * @author Manuel Nguyen & Digvijaysinh D. Raj
 */
public class Ristoratori {

    /**
     * Questo è il metodo main che viene avviato quando avviamo l'applicazione
     */
    public static void main(String[] args) {
        new Ristorante().registraRistorante(); 
    }
}
