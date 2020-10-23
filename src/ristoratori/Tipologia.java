package ristoratori;

/**
 * Tipologia è la classe che gestisce 
 * la tipologia di ogni ristorante che può essere:
 * - Italiano
 * - Etnico
 * - Fusion
 * @author Manuel Nguyen & Digvijaysinh D. Raj
 */
public class Tipologia {
    private String tipo;

    /**
     * Il costruttore inizializza la stringa tipo
     * @param tipo Stringa che rappresenta la tipologia
     */
    public Tipologia(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo che restituisce la stringa rappresentante la tipologia
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Il metodo inizializza l'attributo tipo
     * @param tipo Stringa che rappresenta la tipologia
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo toString() della classe che restituisce la stringa rappresentante la tipologia
     * @return tipo
     */
    @Override
    public String toString() {
        return tipo;
    }
  
}
