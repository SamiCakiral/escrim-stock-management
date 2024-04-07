
package com.webapp.mvc.model;
import java.util.ArrayList;

import com.webapp.mvc.model.personne.personnel.*;
import com.webapp.mvc.model.personne.*;
import com.webapp.mvc.model.personne.mission.EquipeSauvetage;
import com.webapp.mvc.model.materiel.*;

import com.webapp.mvc.model.materiel.Traitement;


public class Application {
    private static Application instance;
    private ArrayList<Personnel> personnelList;
    private ArrayList<MaterielMedical> materielList;
    private ArrayList<Patient> patientList;

    private Application() {
        // private constructor to prevent instantiation
        personnelList = new ArrayList<>();
        materielList = new ArrayList<>();
        patientList = new ArrayList<>();
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

    // A voir si on garde addPersonnel ou si on passe a addPersonnel en private et on a des methodes addMedecins et addEquipesSauvetage
    private void addPersonnel(Personnel personnel) {
        personnelList.add(personnel);
    }

    public void addMedecin(String nom, String titre, String departement, String specialite) {
        PersonnelMedical medecin = new PersonnelMedical(nom, titre, departement, specialite);
        addPersonnel(medecin);
    }

    public void addMilitaire(String nom, String titre, String departement, String rang) {
        PersonnelMilitaire militaire = new PersonnelMilitaire(nom, titre, departement, rang);
        addPersonnel(militaire);
    }

    public void addMateriel(MaterielMedical materiel) {
        materielList.add(materiel);
    }

    private void addPatient(Patient patient) {
        patientList.add(patient);
    }
    
    public void addPatient( String nom, Traitement[] listeTraitements, Equipement[] equipementsUtilises,
            PersonnelMedical medecinAttitre, boolean etatUrgence) {
        Patient patient = new Patient( nom, listeTraitements, equipementsUtilises, medecinAttitre, etatUrgence);
        addPatient(patient);
    }

    public ArrayList<Personnel> getPersonnelList() {
        return personnelList;
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

    
    // fonction synchroBDD, exportBDD et importBDD a ajouter (synchro permet de synchro les BDD avant et après deploy et import/export permet d'importer/exporter les BDD au lancement de l'application pour la premiere fois si jms utilisée) 


}
