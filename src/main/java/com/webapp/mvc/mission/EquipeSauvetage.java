package com.webapp.mvc.mission;

import com.webapp.mvc.materiel.MaterielMedical;
import com.webapp.mvc.personne.personnel.Personnel;

/**
 * Cette classe représente une équipe de sauvetage.
 * Elle contient des informations sur le nom de l'escouade, l'identifiant, le type d'intervention,
 * le personnel déployé, le matériel médical déployé et l'état de l'intervention en cours.
 * Elle fournit des méthodes pour accéder et modifier ces informations, ainsi que pour effectuer
 * différentes actions liées à l'équipe de sauvetage.
 *
 * @author CS
 */
public class EquipeSauvetage {
    private String nomEscouade;
    private static int idCounter = 0;
    private int id;
    private String typeIntervention;
    private Personnel personnelDeploye[];
    private MaterielMedical materielDeploye[];
    private boolean interventionEnCours;

    /**
     * Constructeur de la classe EquipeSauvetage.
     *
     * @param nomEscouade       Le nom de l'escouade.
     * @param typeIntervention  Le type d'intervention.
     * @param personnelDeploye  Le personnel déployé.
     * @param materielDeploye   Le matériel médical déployé.
     */
    public EquipeSauvetage(String nomEscouade, String typeIntervention, Personnel[] personnelDeploye,
            MaterielMedical[] materielDeploye) {
        this.nomEscouade = nomEscouade;
        this.id = idCounter++;
        this.typeIntervention = typeIntervention;
        this.personnelDeploye = personnelDeploye;
        this.materielDeploye = materielDeploye;
        this.interventionEnCours = false;
    }

    /**
     * Retourne le nom de l'escouade.
     *
     * @return Le nom de l'escouade.
     */
    public String getNomEscouade() {
        return nomEscouade;
    }

    /**
     * Modifie le nom de l'escouade.
     *
     * @param nomEscouade Le nouveau nom de l'escouade.
     */
    public void setNomEscouade(String nomEscouade) {
        this.nomEscouade = nomEscouade;
    }

    /**
     * Retourne l'identifiant de l'équipe de sauvetage.
     *
     * @return L'identifiant de l'équipe de sauvetage.
     */
    public int getId() {
        return id;
    }

    /**
     * Retourne le type d'intervention de l'équipe de sauvetage.
     *
     * @return Le type d'intervention de l'équipe de sauvetage.
     */
    public String getTypeIntervention() {
        return typeIntervention;
    }

    /**
     * Modifie le type d'intervention de l'équipe de sauvetage.
     *
     * @param typeIntervention Le nouveau type d'intervention.
     */
    public void setTypeIntervention(String typeIntervention) {
        this.typeIntervention = typeIntervention;
    }

    /**
     * Retourne le personnel déployé par l'équipe de sauvetage.
     *
     * @return Le personnel déployé par l'équipe de sauvetage.
     */
    public Personnel[] getPersonnelDeploye() {
        return personnelDeploye;
    }

    /**
     * Modifie le personnel déployé par l'équipe de sauvetage.
     *
     * @param personnelDeploye Le nouveau personnel déployé.
     */
    public void setPersonnelDeploye(Personnel[] personnelDeploye) {
        this.personnelDeploye = personnelDeploye;
    }

    /**
     * Retourne le matériel médical déployé par l'équipe de sauvetage.
     *
     * @return Le matériel médical déployé par l'équipe de sauvetage.
     */
    public MaterielMedical[] getMaterielDeploye() {
        return materielDeploye;
    }

    /**
     * Modifie le matériel médical déployé par l'équipe de sauvetage.
     *
     * @param materielDeploye Le nouveau matériel médical déployé.
     */
    public void setMaterielDeploye(MaterielMedical[] materielDeploye) {
        this.materielDeploye = materielDeploye;
    }

    /**
     * Déploie l'équipe de sauvetage.
     */
    public void deployerEquipe() {
        System.out.println("Equipe déployée");
    }

    /**
     * Vérifie le matériel médical déployé par l'équipe de sauvetage.
     */
    public void verifierMateriel() {
        System.out.println("Matériel vérifié");
    }

    /**
     * Vérifie le personnel déployé par l'équipe de sauvetage.
     */
    public void verifierPersonnel() {
        System.out.println("Personnel vérifié");
    }

    /**
     * Lance l'intervention de l'équipe de sauvetage.
     */
    public void intervenir() {
        if (interventionEnCours) {
            System.out.println("Intervention en cours");
        } else {
            interventionEnCours = true;
            System.out.println("Intervention en cours");
        }
    }

    /**
     * Effectue le retour à la base de l'équipe de sauvetage.
     */
    public void retourBase() {
        System.out.println("Retour à la base");
    }

    /**
     * Génère le rapport d'intervention de l'équipe de sauvetage.
     */
    public void rapportIntervention() {
        System.out.println("Rapport d'intervention");
    }

    /**
     * Génère le rapport du matériel médical de l'équipe de sauvetage.
     */
    public void rapportMateriel() {
        System.out.println("Rapport matériel");
    }
}
