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
import com.webapp.mvc.materiel.*;
import com.webapp.mvc.personne.patient.*;
/**
 * Cette classe représente l'application de gestion de l'unité médicale.
 * Elle contient les listes de personnel, de matériel médical, de patients et de colis.
 * Elle fournit des méthodes pour accéder et modifier ces listes, ainsi que pour effectuer
 * différentes actions liées à l'application.
 * 
 * @Author CS
 */

public class Application {
    private static Application instance;
    private ArrayList<Personnel> personnelList;
    private ArrayList<MaterielMedical> materielList;
    private ArrayList<Patient> patientList;
    private ArrayList<Coli> coliList;
    private ArrayList<Traitement> listeTraitements;

    /**
     * Constructeur privé pour empêcher l'instanciation directe de la classe.
     * Initialise les listes de personnel, de matériel médical, de patients et de colis.
     */
    private Application() {
        // private constructor to prevent instantiation
        personnelList = new ArrayList<>();
        materielList = new ArrayList<>();
        patientList = new ArrayList<>();
        coliList = new ArrayList<>(); 

        listeTraitements = new ArrayList<>();

        DAOManager daoManager = DAOManager.getInstance();
        DAOPersonnel daoPersonnel = daoManager.getDAOPersonnel();
        DAOMateriel daoMateriel = daoManager.getDAOMateriel();
        DAOPatient daoPatient = daoManager.getDAOPatient();
        DAOStock daoStock = daoManager.getDAOStock();

        // Initialisation des listes de personnel, de matériel médical, de patients et de colis grace au DAO: 
        personnelList = daoPersonnel.findAllPersonnel();
        materielList = daoMateriel.findAllMateriel();
        patientList = daoPatient.findAllPatients();
        coliList = daoStock.findAllColis();
        
    }

    /**
     * Retourne l'instance unique de l'application.
     * Si aucune instance n'existe, crée une nouvelle instance en utilisant le double verrouillage pour la synchronisation.
     * 
     * @return L'instance unique de l'application
     */
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

    /**
     * Ajoute un personnel à la liste du personnel.
     * 
     * @param personnel Le personnel à ajouter
     */
    private void addPersonnel(Personnel personnel) {
        personnelList.add(personnel);
    }

    /**
     * Ajoute un médecin à la liste du personnel.
     * 
     * @param nom Le nom du médecin
     * @param titre Le titre du médecin
     * @param affectation L'affectation du médecin
     */
    public void addMedecin(String lastName,String firstName, String affectation) {
        PersonnelMedical medecin = new PersonnelMedical(lastName,firstName, affectation);
        addPersonnel(medecin);
    }

    /**
     * Ajoute un militaire à la liste du personnel.
     * 
     * @param nom Le nom du militaire
     * @param titre Le titre du militaire
     * @param affectation L'affectation du militaire
     */
    public void addMilitaire(String lastName, String firstName, String affectation) {
        PersonnelMilitaire militaire = new PersonnelMilitaire(lastName, firstName, affectation);
        addPersonnel(militaire);
    }
    
    /**
     * Ajoute un matériel médical à la liste du matériel médical.
     * 
     * @param materiel Le matériel médical à ajouter
     */
    public void addMateriel(MaterielMedical materiel) {
        materielList.add(materiel);
    }

    /**
     * Ajoute un équipement à la liste du matériel médical.
     * 
     * @param nom Le nom de l'équipement
     * @param quantiteEnStock La quantité en stock de l'équipement
     * @param description La description de l'équipement
     * @param fournisseur Le fournisseur de l'équipement
     * @param dateExpiration La date d'expiration de l'équipement
     * @param coliId L'ID du colis auquel l'équipement est associé
     * @param poids Le poids de l'équipement
     */
    public void addEquipement(String nom, int quantiteEnStock, String description, String fournisseur, Date dateExpiration, int coliId, double poids) {
        Equipement eq = new Equipement(nom, quantiteEnStock, description, fournisseur, dateExpiration, coliId, poids);
        addMateriel(eq);
    }    

    /**
     * Ajoute un médicament à la liste du matériel médical.
     * 
     * @param nom Le nom du médicament
     * @param quantiteEnStock La quantité en stock du médicament
     * @param description La description du médicament
     * @param fournisseur Le fournisseur du médicament
     * @param dateExpiration La date d'expiration du médicament
     * @param coliId L'ID du colis auquel le médicament est associé
     * @param poids Le poids du médicament
     */
    public void addMedicament(String nom, int quantiteEnStock, String description, String fournisseur, Date dateExpiration, int coliId, double poids){
        Medicament md = new Medicament(nom, quantiteEnStock, description, fournisseur, dateExpiration, null, null, coliId, poids);
        addMateriel(md);
    }

    /**
     * Ajoute un patient à la liste des patients.
     * 
     * @param patient Le patient à ajouter
     */
    private void addPatient(Patient patient) {
        patientList.add(patient);
    }

    /**
     * Ajoute un patient à la liste des patients.
     * 
     * @param nom Le nom du patient
     * @param listeTraitements La liste des traitements du patient
     * @param equipementsUtilises Les équipements utilisés par le patient
     * @param medecinAttitre Le médecin attitré du patient
     * @param etatUrgence L'état d'urgence du patient
     * @param prenom Le prénom du patient
     * @param dob La date de naissance du patient
     */
    public void addPatient(String nom, Traitement[] listeTraitements, Equipement[] equipementsUtilises,
            PersonnelMedical medecinAttitre, boolean etatUrgence,String prenom, Date dob) {
        Patient patient = new Patient(nom,prenom,dob, listeTraitements, equipementsUtilises, medecinAttitre, etatUrgence);
        addPatient(patient);
    }

    /**
     * Retourne le traitement correspondant à l'ID spécifié.
     * 
     * @param ids L'ID du traitement
     * @return Le traitement correspondant à l'ID, ou null si aucun traitement n'est trouvé
     */
    public Traitement getTraitementById(Integer ids){
        for (Traitement traitement : listeTraitements) {
            if (traitement.getId() == ids) {
                return traitement;
            }
        }
        return null;
    }
    /**
     * Retourne l'équipement correspondant à l'ID spécifié.
     * 
     * @param ids L'ID de l'équipement
     * @return L'équipement correspondant à l'ID, ou null si aucun équipement n'est trouvé
     */
    public Equipement getEquipementById(Integer  ids){
        for (MaterielMedical materiel : materielList) {
            if (materiel instanceof Equipement && materiel.getId() == ids) {
                return (Equipement) materiel;
            }
        }
        return null;
    }
    /**
     * Retourne le personnel médical correspondant à l'ID spécifié.
     * 
     * @param id L'ID du personnel médical
     * @return Le personnel médical correspondant à l'ID, ou null si aucun personnel médical n'est trouvé
     */
    public PersonnelMedical getPersonnelMedicalById(int id) {
        for (Personnel personnel : personnelList) {
            if (personnel instanceof PersonnelMedical && personnel.getId() == id) {
                return (PersonnelMedical) personnel;
            }
        }
        return null;
    }

    /**
     * Retourne la liste du personnel.
     * 
     * @return La liste du personnel
     */
    public ArrayList<Personnel> getPersonnelList() {
        return personnelList;
    }

    /**
     * Retourne la liste des colis.
     * 
     * @return La liste des colis
     */
    public ArrayList<Coli> getColiList() {
        return coliList;
    }

    /**
     * Ajoute un colis à la liste des colis.
     * 
     * @param coli Le colis à ajouter
     */
    public void addColi(Coli coli){
        coliList.add(coli); 
    }

    /**
     * Ajoute un colis à la liste des colis.
     * 
     * @param nom Le nom du colis
     * @param type Le type du colis
     * @param materielMedicalIDs Les IDs du matériel médical associé au colis
     */
    public void addColi(String nom, String type, Integer [] materielMedicalIDs){ 
        Coli coli = new Coli(nom, type, materielMedicalIDs); 

        addColi(coli);
    }

    /**
     * Retourne le patient correspondant à l'ID spécifié.
     * 
     * @param id L'ID du patient
     * @return Le patient correspondant à l'ID, ou null si aucun patient n'est trouvé
     */
    public Patient getPatientById(int id) {
        for (Patient patient : patientList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    /**
     * Retourne la liste du matériel médical.
     * 
     * @return La liste du matériel médical
     */
    public ArrayList<MaterielMedical> getMaterielList() {
        return materielList;
    }

    /**
     * Retourne la liste des patients.
     * 
     * @return La liste des patients
     */
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    /**
     * Méthode principale de l'application.
     * Crée une instance de l'application et affiche l'instance.
     * 
     * @param args Les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        Application app = Application.getInstance();
        System.out.println(app);
    }

    /**
     * Retourne le colis correspondant à l'ID spécifié.
     * 
     * @param id L'ID du colis
     * @return Le colis correspondant à l'ID, ou null si aucun colis n'est trouvé
     */
    public Coli getColiById(int id){
        for(Coli coli : coliList){
            if(coli.getId() == id){
                return coli; 
            }
        }
        return null; 
    }
    
    /**
     * Retourne le personnel correspondant à l'ID spécifié.
     * 
     * @param id L'ID du personnel
     * @return Le personnel correspondant à l'ID, ou null si aucun personnel n'est trouvé
     */
    public Personnel getPersonnelById(int id) {
        for (Personnel personnel : personnelList) {
            if (personnel.getId() == id) {
                return personnel;
            }
        }
        return null;
    }

    /**
     * Retourne le matériel médical correspondant à l'ID spécifié.
     * 
     * @param id L'ID du matériel médical
     * @return Le matériel médical correspondant à l'ID, ou null si aucun matériel médical n'est trouvé
     */
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

