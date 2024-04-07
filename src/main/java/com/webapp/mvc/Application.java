
package com.webapp.mvc;
import java.util.ArrayList;

import com.webapp.mvc.model.personne.personnel.*;
import com.webapp.mvc.model.personne.*;
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
    public void addPersonnel(Personnel personnel) {
        personnelList.add(personnel);
    }

    public void addMateriel(MaterielMedical materiel) {
        materielList.add(materiel);
    }

    private void addPatient(Patient patient) {
        patientList.add(patient);
    }
    
    public void addPatient(int id, String nom, Traitement[] listeTraitements, Equipement[] equipementsUtilises,
            PersonnelMedical medecinAttitre, boolean etatUrgence) {
        Patient patient = new Patient(id, nom, listeTraitements, equipementsUtilises, medecinAttitre, etatUrgence);
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

    
    


}
