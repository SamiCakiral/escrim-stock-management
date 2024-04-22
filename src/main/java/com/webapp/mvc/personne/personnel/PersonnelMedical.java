package com.webapp.mvc.personne.personnel;

/**
 * Cette classe représente un membre du personnel médical dans l'application.
 * Elle hérite de la classe abstraite Personnel.
 * 
 * @author CS
 */
public class PersonnelMedical extends Personnel {
    
    private String specialite = "";

    /**
     * Constructeur de la classe PersonnelMedical.
     * 
     * @param last_name    le nom de famille du membre du personnel médical
     * @param first_name   le prénom du membre du personnel médical
     * @param affectation  l'affectation du membre du personnel médical
     */
    public PersonnelMedical(String last_name, String first_name, String affectation) {
        super(last_name, first_name, affectation, "Médecin");
    }

    /**
     * Assigner une spécialité au membre du personnel médical.
     * 
     * @param specialite  la spécialité à assigner
     */
    public void assignerSpecialite(String specialite) {
        this.specialite = specialite;
    }

    /**
     * Obtenir la spécialité du membre du personnel médical.
     * 
     * @return la spécialité du membre du personnel médical
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * Modifier la spécialité du membre du personnel médical.
     * 
     * @param specialite  la nouvelle spécialité à définir
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    /**
     * Cette méthode permet au membre du personnel médical d'effectuer une tâche spécifique.
     * Dans cette classe, cette méthode est vide car elle est abstraite dans la classe parente.
     */
    @Override
    public void effectuerTache() {
        // Cette méthode est vide car elle est abstraite dans la classe parente.
    }

}
