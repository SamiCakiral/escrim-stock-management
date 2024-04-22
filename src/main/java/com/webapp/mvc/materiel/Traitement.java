package com.webapp.mvc.materiel;

/**
 * Cette classe représente un traitement médical.
 * 
 * @author CS
 */
public class Traitement {
    private int id;
    private String description;
    private Medicament médicament;
    private String fréquence;
    private String dose;

    /**
     * Constructeur de la classe Traitement.
     * 
     * @param id          l'identifiant du traitement
     * @param description la description du traitement
     * @param médicament  le médicament associé au traitement
     * @param fréquence   la fréquence du traitement
     * @param dose        la dose du traitement
     */
    public Traitement(int id, String description, Medicament médicament, String fréquence, String dose) {
        this.id = id;
        this.description = description;
        this.médicament = médicament;
        this.fréquence = fréquence;
        this.dose = dose;
    }

    /**
     * Méthode permettant de prescrire un médicament pour ce traitement.
     * 
     * @param médicament le médicament à prescrire
     */
    public void prescrireMédicament(Medicament médicament) {
        // TODO: Implement prescrireMédicament method
    }

    /**
     * Méthode permettant de planifier le traitement.
     */
    public void planifierTraitement() {
        // TODO: Implement planifierTraitement method
    }

    // Getters and Setters

    /**
     * Retourne l'identifiant du traitement.
     * 
     * @return l'identifiant du traitement
     */
    public int getId() {
        return id;
    }

    /**
     * Modifie l'identifiant du traitement.
     * 
     * @param id le nouvel identifiant du traitement
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retourne la description du traitement.
     * 
     * @return la description du traitement
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifie la description du traitement.
     * 
     * @param description la nouvelle description du traitement
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne le médicament associé au traitement.
     * 
     * @return le médicament associé au traitement
     */
    public Medicament getMedicament() {
        return médicament;
    }

    /**
     * Modifie le médicament associé au traitement.
     * 
     * @param médicament le nouveau médicament associé au traitement
     */
    public void setMédicament(Medicament médicament) {
        this.médicament = médicament;
    }

    /**
     * Retourne la fréquence du traitement.
     * 
     * @return la fréquence du traitement
     */
    public String getFréquence() {
        return fréquence;
    }

    /**
     * Modifie la fréquence du traitement.
     * 
     * @param fréquence la nouvelle fréquence du traitement
     */
    public void setFrequence(String fréquence) {
        this.fréquence = fréquence;
    }

    /**
     * Retourne la dose du traitement.
     * 
     * @return la dose du traitement
     */
    public String getDose() {
        return dose;
    }

    /**
     * Modifie la dose du traitement.
     * 
     * @param dose la nouvelle dose du traitement
     */
    public void setDose(String dose) {
        this.dose = dose;
    }
}
