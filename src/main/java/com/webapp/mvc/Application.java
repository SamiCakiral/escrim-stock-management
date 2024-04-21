package com.webapp.mvc;

import java.util.ArrayList;
import java.util.Date;

import com.webapp.mvc.personne.patient.Patient;
import com.webapp.mvc.personne.personnel.*;
import com.webapp.mvc.materiel.Equipement;
import com.webapp.mvc.materiel.MaterielMedical;
import com.webapp.mvc.materiel.Medicament;
import com.webapp.mvc.materiel.Traitement;
import com.webapp.mvc.stock.*;

public class Application {
    private static Application instance;
    private ArrayList<Personnel> personnelList;
    private ArrayList<MaterielMedical> materielList;
    private ArrayList<Patient> patientList;
    private ArrayList<Coli> coliList;


    private Application() {
        // private constructor to prevent instantiation
        personnelList = new ArrayList<>();
        materielList = new ArrayList<>();
        patientList = new ArrayList<>();
        coliList = new ArrayList<>(); 
    }

    public static Application getInstance() {
        if (instance == null) {
            synchronized (Application.class) {
                if (instance == null) {
                    instance = new Application();
                }
            }
        }
        return instance;
    }

    // A voir si on garde addPersonnel ou si on passe a addPersonnel en private et
    // on a des methodes addMedecins et addEquipesSauvetage
    private void addPersonnel(Personnel personnel) {
        personnelList.add(personnel);
    }

    public void addMedecin(String nom, String titre, String affectation) {
        PersonnelMedical medecin = new PersonnelMedical(nom, titre, affectation);
        addPersonnel(medecin);
    }

    public void addMilitaire(String nom, String titre, String affectation) {
        PersonnelMilitaire militaire = new PersonnelMilitaire(nom, titre, affectation);
        addPersonnel(militaire);
    }

    public void addMateriel(MaterielMedical materiel) {
        materielList.add(materiel);
    }

    public void addEquipement(String nom, int quantiteEnStock, String description, String fournisseur, Date dateExpiration, int coliId, double poids) {
        Equipement eq = new Equipement(nom, quantiteEnStock, description, fournisseur, null, null, null, coliId, poids);
        addMateriel(eq);
    }    

    public void addMedicament(String nom, int quantiteEnStock, String description, String fournisseur, Date dateExpiration, int coliId, double poids){
        Medicament md = new Medicament(nom, quantiteEnStock, description, fournisseur, dateExpiration, null, null, coliId, poids);
        addMateriel(md);
    }

    private void addPatient(Patient patient) {
        patientList.add(patient);
    }

    public void addPatient(String nom, Traitement[] listeTraitements, Equipement[] equipementsUtilises,
            PersonnelMedical medecinAttitre, boolean etatUrgence) {
        Patient patient = new Patient(nom, listeTraitements, equipementsUtilises, medecinAttitre, etatUrgence);
        addPatient(patient);
    }

    public ArrayList<Personnel> getPersonnelList() {
        return personnelList;
    }

    public ArrayList<Coli> getColiList() {
        return coliList;
    }

    public void addColi(Coli coli){
        coliList.add(coli); 
    }

    public void addColi(String nom, String type, Integer [] materielMedicalIDs){ 
        Coli coli = new Coli(nom, type, materielMedicalIDs); 

        addColi(coli);
    }

    public Patient getPatientById(int id) {
        for (Patient patient : patientList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public ArrayList<MaterielMedical> getMaterielList() {
        return materielList;
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public static void main(String[] args) {
        Application app = Application.getInstance();
        System.out.println(app);
    }

    public Coli getColiById(int id){
        for(Coli coli : coliList){
            if(coli.getId() == id){
                return coli; 
            }
        }
        return null; 
    }
    
    public Personnel getPersonnelById(int id) {
        for (Personnel personnel : personnelList) {
            if (personnel.getId() == id) {
                return personnel;
            }
        }
        return null;
    }

    public MaterielMedical getMaterielById(int id) {
        for (MaterielMedical materiel : materielList) {
            if (materiel.getId() == id) {
                return materiel;
            }
        }
        return null;
    }

    // fonction synchroBDD, exportBDD et importBDD a ajouter (synchro permet de
    // synchro les BDD avant et après deploy et import/export permet
    // d'importer/exporter les BDD au lancement de l'application pour la premiere
    // fois si jms utilisée)

}
