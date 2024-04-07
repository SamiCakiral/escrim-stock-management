package com.webapp.mvc.model.personne;

import com.webapp.mvc.model.medical.Equipement;
import com.webapp.mvc.model.medical.Traitement;
import com.webapp.mvc.model.personne.personnel.PersonnelMedical;

public class Patient {
    private int id;
    private String nom;
    private Traitement[] listeTraitements;
    private Equipement[] equipementsUtilises;
    private PersonnelMedical medecinAttitre;
    private boolean etatUrgence;

    public void attribuerMedecin(PersonnelMedical medecin) {
        this.medecinAttitre = medecin;
    }

    public void ajouterTraitement(Traitement traitement) {
        // Add the treatment to the list of treatments
    }

    public void utiliserEquipement(Equipement equipement) {
        // Use the equipment
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Traitement[] getListeTraitements() {
        return listeTraitements;
    }

    public void setListeTraitements(Traitement[] listeTraitements) {
        this.listeTraitements = listeTraitements;
    }

    public Equipement[] getEquipementsUtilises() {
        return equipementsUtilises;
    }

    public void setEquipementsUtilises(Equipement[] equipementsUtilises) {
        this.equipementsUtilises = equipementsUtilises;
    }

    public PersonnelMedical getMedecinAttitre() {
        return medecinAttitre;
    }

    public void setMedecinAttitre(PersonnelMedical medecinAttitre) {
        this.medecinAttitre = medecinAttitre;
    }

    public boolean isEtatUrgence() {
        return etatUrgence;
    }

    public void setEtatUrgence(boolean etatUrgence) {
        this.etatUrgence = etatUrgence;
    }
}