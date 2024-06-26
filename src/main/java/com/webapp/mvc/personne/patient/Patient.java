package com.webapp.mvc.personne.patient;

import com.webapp.mvc.DAOManager;
import com.webapp.mvc.materiel.Equipement;
import com.webapp.mvc.materiel.Traitement;
import com.webapp.mvc.personne.personnel.DAOPersonnel;
import com.webapp.mvc.personne.personnel.PersonnelMedical;
import java.util.Date;
import org.apache.log4j.Logger;
import org.hibernate.mapping.Index;

public class Patient {
    private static int idCounter = 0;
    private int id;
    private String nom;
    private String prenom;
    private Date dob;
    private Traitement[] listeTraitements;
    private Equipement[] equipementsUtilises;
    private PersonnelMedical medecinAttitre;
    private boolean etatUrgence;

    private static final Logger log = Logger.getLogger(Patient.class); 
    public Patient(String nom,String prenom, Date dob, Traitement[] listeTraitements, Equipement[] equipementsUtilises,
            PersonnelMedical medecinAttitre, boolean etatUrgence) {
        this.id = idCounter++;
        this.nom = nom;
        this.prenom = prenom;
        this.dob = dob;
        this.listeTraitements = listeTraitements;
        this.equipementsUtilises = equipementsUtilises;
        this.medecinAttitre = medecinAttitre;
        this.etatUrgence = etatUrgence;
        log.info("Patient created: " + this.toString());
    }

    @Override
    public String toString() {
        return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dob=" + dob + ", listeTraitements="
                + listeTraitements + ", equipementsUtilises=" + equipementsUtilises + ", medecinAttitre=" + medecinAttitre
                + ", etatUrgence=" + etatUrgence + "]";
    }
    
    public void setId(int id) {
        this.id = id;
    }  
    
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
        try{
            this.medecinAttitre.getId();
        }catch(NullPointerException e){
            log.error("Medecin attitré non défini, Medecin existe plus ou a jamais existé " + e.getMessage());
            try{ PersonnelMedical medecinParDefault = DAOManager.getInstance().getDAOPersonnel().findAllPersonnelMedical()[0];
                this.medecinAttitre = medecinParDefault;
            }catch(IndexOutOfBoundsException e2){
                log.error("Aucun medecin n'est disponible pour l'attribution, veuillez en ajouter un " + e2.getMessage());
                this.medecinAttitre = new PersonnelMedical("Pas de Medecin", "disponible", "Aucune affectation");
            }
           

        }
        
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