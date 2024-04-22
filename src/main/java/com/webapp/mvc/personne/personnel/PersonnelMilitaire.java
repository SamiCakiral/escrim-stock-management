package com.webapp.mvc.personne.personnel;

/**
 * Cette classe représente un personnel militaire.
 * Elle hérite de la classe abstraite Personnel.
 * 
 * @author CS
 */
public class PersonnelMilitaire extends Personnel {

    private String rang;

    /**
     * Constructeur de la classe PersonnelMilitaire.
     * 
     * @param name       Le nom du personnel militaire.
     * @param titre      Le titre du personnel militaire.
     * @param affectation L'affectation du personnel militaire.
     */
    public PersonnelMilitaire(String name, String titre, String affectation) {
        super(name, titre, affectation, "Militaire");
        
        RangPersonnel rg = new RangPersonnel();
        this.rang = rg.getAbbreviation(titre);
    }

    /**
     * Assigner un rang au personnel militaire.
     * 
     * @param rang Le rang à assigner.
     */
    public void assignerRang(String rang) {
        this.rang = rang;
    }

    /**
     * Obtenir le rang du personnel militaire.
     * 
     * @return Le rang du personnel militaire.
     */
    public String getRang() {
        return rang;
    }

    /**
     * Modifier le rang du personnel militaire.
     * 
     * @param rang Le nouveau rang du personnel militaire.
     */
    public void setRang(String rang) {
        this.rang = rang;
    }

    /**
     * Effectuer la tâche spécifique du personnel militaire.
     * Cette méthode est héritée de la classe abstraite Personnel.
     */
    @Override
    public void effectuerTache() {
        // TODO: Implémenter la logique de la tâche spécifique du personnel militaire
    }

}
