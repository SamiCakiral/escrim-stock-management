/**
 * Cette classe représente un colis dans le stock de l'application.
 * Un colis est composé d'un ensemble de matériel médical, d'un identifiant, d'un nom, d'un type, d'un poids et de dimensions.
 * 
 * @author CS
 */
package com.webapp.mvc.stock;

import java.util.ArrayList;
import java.util.Arrays;

import com.webapp.mvc.materiel.MaterielMedical;

import java.util.Date;
import com.webapp.mvc.Application;

import com.webapp.mvc.materiel.Equipement;

import com.webapp.mvc.materiel.Medicament;

/**
 * La classe Coli représente un colis qui contient du matériel médical.
 * Elle stocke des informations telles que l'ID du colis, le nom, le type, le poids, les dimensions et la liste des ID du matériel médical qu'il contient.
 * 
 * @author CS
 */
public class Coli {
    /**
     * Liste des ID du matériel médical contenu dans le colis.
     */
    private ArrayList<Integer> listMaterielMedical;
    /**
     * ID du colis.
     */
    private int id;
    /**
     * Compteur d'ID pour les colis.
     */
    private static int idCounter = 0;
    /**
     * Nom du colis.
     */
    private String nom;
    /**
     * Type du colis.
     */
    private String type;
    /**
     * Poids du colis.
     */
    private double poids;
    /**
     * Dimensions du colis.
     */
    private double[] dimensions;

    /**
     * Constructeur de la classe Coli.
     * 
     * @param nom Le nom du colis.
     * @param type Le type du colis.
     * @param materielMedicalIds Les ID du matériel médical contenu dans le colis.
     */
    public Coli(String nom, String type, Integer[] materielMedicalIds) {

        this.listMaterielMedical.addAll(Arrays.asList(materielMedicalIds)); // Si on a une liste de int ca marche pas comme si on avait une liste de Integer
        this.type = type;
        setDimensions(type); // SET les dimensions du coli en fonction du type
        this.id = idCounter++;
        this.nom = nom;
        this.poids = calcPoids();
    }

    /**
     * Calcule le poids total du colis en prenant en compte le poids du matériel médical qu'il contient.
     * 
     * @return Le poids total du colis.
     */
    public double calcPoids() {
        double poids = 0;
        for (int materielId : listMaterielMedical) {
            MaterielMedical materiel = Application.getInstance().getMaterielById(materielId);
            poids += materiel.getPoids();
        }
        poids += poidsColis(this.type);
        return poids;
    }

    /**
     * Calcule le poids du colis en fonction de son type.
     * 
     * @param type Le type du colis.
     * @return Le poids du colis.
     */
    public double poidsColis(String type) {
        switch (type) {
            case "PAL":
                return 30; // Poids arbitraire a changer en fonction de la taille du colis et des valeurs rééels
            case "MAL":
                return 20;
            case "FAR":
                return 25;
            case "BAC":
                return 10;
            default:
                return 0;
        }
    }

    /**
     * Retourne le poids du colis.
     * 
     * @return Le poids du colis.
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Retourne les dimensions du colis.
     * 
     * @return Les dimensions du colis.
     */
    public double[] getDimensions() {
        return dimensions;
    }

    /**
     * Définit les dimensions du colis en fonction de son type.
     * 
     * @param type Le type du colis.
     */
    public void setDimensions(String type) {
        double[] dimensions = new double[3];
        switch (type) {
            case "PAL":
                dimensions[0] = 1.2; // Dimensions arbitraires a changer en fonction de la taille du colis et des valeurs rééels
                dimensions[1] = 1.2;
                dimensions[2] = 1.2;
                break;
            case "MAL":
                dimensions[0] = 1.2; // X
                dimensions[1] = 1.2; // Y
                dimensions[2] = 1.2; // Z
                break;
            case "FAR":
                dimensions[0] = 1.2;
                dimensions[1] = 1.2;
                dimensions[2] = 1.2;
                break;
            case "BAC":
                dimensions[0] = 1.2;
                dimensions[1] = 1.2;
                dimensions[2] = 1.2;
                break;
            default:
                dimensions[0] = 0;
                dimensions[1] = 0;
                dimensions[2] = 0;
                break;
        }
        this.dimensions = dimensions;
    }

    // Setters

    /**
     * Définit le type du colis.
     * 
     * @param type Le type du colis.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Définit le nom du colis.
     * 
     * @param nom Le nom du colis.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getters

    /**
     * Retourne la liste des ID du matériel médical contenu dans le colis.
     * 
     * @return La liste des ID du matériel médical.
     */
    public ArrayList<Integer> getListMaterielMedical() {
        return listMaterielMedical;
    }

    /**
     * Retourne le type du colis.
     * 
     * @return Le type du colis.
     */
    public String getType() {
        return type;
    }

    /**
     * Retourne l'ID du colis.
     * 
     * @return L'ID du colis.
     */
    public int getId() {
        return id;
    }

    /**
     * Retourne le nom du colis.
     * 
     * @return Le nom du colis.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le matériel médical correspondant à l'ID spécifié.
     * 
     * @param id L'ID du matériel médical.
     * @return Le matériel médical correspondant à l'ID spécifié.
     */
    public MaterielMedical getMaterielById(int id) {
        for (int idMateriel : listMaterielMedical) {
            MaterielMedical materiel = Application.getInstance().getMaterielById(idMateriel);
            if (materiel.getId() == id) {
                return materiel;
            }
        }
        return null;
    }

    /**
     * Ajoute un matériel médical à la liste du colis.
     * 
     * @param materiel L'ID du matériel médical à ajouter.
     */
    public void addMateriel(int materiel) {
        listMaterielMedical.add(materiel);
    }

    /**
     * Supprime un matériel médical de la liste du colis.
     * 
     * @param id L'ID du matériel médical à supprimer.
     */
    public void removeMateriel(int id) {
        MaterielMedical materiel = getMaterielById(id);
        if (materiel != null) {
            for (int i = 0; i < listMaterielMedical.size(); i++) {
                if (listMaterielMedical.get(i) == id) {
                    listMaterielMedical.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * Ajoute un équipement au colis.
     * 
     * @param nom Le nom de l'équipement.
     * @param quantiteEnStock La quantité en stock de l'équipement.
     * @param description La description de l'équipement.
     * @param fournisseur Le fournisseur de l'équipement.
     * @param dateExpiration La date d'expiration de l'équipement.
     * @param ColiId L'ID du colis.
     * @param poids Le poids de l'équipement.
     */
    public void addEquipement(String nom, int quantiteEnStock, String description, String fournisseur,
            Date dateExpiration, int ColiId, double poids) {
        Equipement eq = new Equipement(nom, quantiteEnStock, description, fournisseur, null, null, null, ColiId, poids);
        int idEq = eq.getId();
        addMateriel(idEq);
    }

    /**
     * Ajoute un médicament au colis.
     * 
     * @param nom Le nom du médicament.
     * @param quantiteEnStock La quantité en stock du médicament.
     * @param description La description du médicament.
     * @param fournisseur Le fournisseur du médicament.
     * @param dateExpiration La date d'expiration du médicament.
     * @param ColiId L'ID du colis.
     * @param poids Le poids du médicament.
     */
    public void addMedicament(String nom, int quantiteEnStock, String description, String fournisseur,
            Date dateExpiration, int ColiId, double poids) {
        Medicament md = new Medicament(nom, quantiteEnStock, description, fournisseur, dateExpiration, null, null,
                ColiId, poids);
        int idMd = md.getId();
        addMateriel(idMd);
    }
}
    