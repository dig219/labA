package ristoratori;

/**
 * Indirizzo è la classe che gestisce l'indirizzo di un
 * ristorante, diviso in:
 * - qualificatore (via,viale,corso,piazza,piazzale)
 * - nome
 * - numeroCivico
 * - comune
 * - siglaProvincia
 * - Cap
 * 
 * @author Manuel Nguyen & Digvijaysinh D. Raj
 */
public class Indirizzo {
    private String qualificatore;
    private String nome;
    private String numeroCivico;
    private String comune;
    private String siglaProvincia;
    private String Cap;

    /**
     * Costruttore vuoto per inizializzare l'oggetto dal metodo richiamante
     */
    public Indirizzo() {
    }

    /**
     * Costruttore che, dati i param, setta gli attributi della classe Indirizzo
     * 
     * @param qualificatore
     * @param nome
     * @param numeroCivico
     * @param comune
     * @param siglaProvincia
     * @param Cap
     */
    public Indirizzo(String qualificatore, String nome, String numeroCivico, String comune, String siglaProvincia, String Cap) {
        this.qualificatore = qualificatore;
        this.nome = nome;
        this.numeroCivico = numeroCivico;
        this.comune = comune;
        this.siglaProvincia = siglaProvincia;
        this.Cap = Cap;
    }
    
    /**
     * Metodo che ritorna la stringa indicante il qualificatore
     * @return qualificatore
     */
    public String getQualificatore() {
        return qualificatore;
    }

    /**
     * Il metodo inizializza l'attributo qualificatore
     * @param qualificatore
     */
    public void setQualificatore(String qualificatore) {
        this.qualificatore = qualificatore;
    }

    /**
     * Metodo che ritorna la stringa nome
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Il metodo inizializza l'attributo nome
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo che ritorna la stringa numeroCivico
     * @return numeroCivico
     */
    public String getNumeroCivico() {
        return numeroCivico;
    }

    /**
     * Il metodo inizializza l'attributo numeroCivico
     * @param numeroCivico
     */
    public void setNumeroCivico(String numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    /**
     * Metodo che ritorna la stringa comune
     * @return comune
     */
    public String getComune() {
        return comune;
    }

    /**
     * Il metodo inizializza l'attributo comune
     * @param comune
     */
    public void setComune(String comune) {
        this.comune = comune;
    }

    /**
     * Metodo che ritorna stringa provincia
     * @return siglaProvincia
     */
    public String getSiglaProvincia() {
        return siglaProvincia;
    }

    /**
     * Il metodo inizializza l'attributo siglaProvincia
     * @param siglaProvincia
     */
    public void setSiglaProvincia(String siglaProvincia) {
        this.siglaProvincia = siglaProvincia;
    }

    /**
     * Metodo che ritorna la stringa Cap
     * @return Cap
     */
    public String getCap() {
        return Cap;
    }

    /**
     * Il metodo inizializza l'attributo Cap
     * @param Cap
     */
    public void setCap(String Cap) {
        this.Cap = Cap;
    }

    /**
     *  Metodo toString() che mette assieme tutti gli attributi della classe
     * con i rispettivi nominativi.
     * @return qualificatore + "-" + nome + "-" + numeroCivico + "-" + comune + "-" + siglaProvincia + "-" + Cap ;
     */
    @Override
    public String toString() {
        return qualificatore + "-" + nome + "-" + numeroCivico + "-" + comune + "-" + siglaProvincia + "-" + Cap ;
    }   
}
