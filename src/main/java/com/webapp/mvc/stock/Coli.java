package com.webapp.mvc.stock;

import java.util.ArrayList;
import java.util.Arrays;

import com.webapp.mvc.materiel.MaterielMedical;

import java.util.Date;
import com.webapp.mvc.Application;

import com.webapp.mvc.materiel.Equipement;

import com.webapp.mvc.materiel.Medicament;

public class Coli {
    private ArrayList<Integer> listMaterielMedical;
    private int id;
    private static int idCounter = 0;
    private String nom;
    private String type;
    private double poids;
    private double[] dimensions;

    public Coli(String nom, String type, Integer[] materielMedicalIds) {

        this.listMaterielMedical.addAll(Arrays.asList(materielMedicalIds)); // Si on a une liste de int ca marche pas comme si on avait une liste de Integer
        this.type = type;
        setDimensions(type); // SET les dimensions du coli en fonction du type
        this.id = idCounter++;
        this.nom = nom;
        this.poids = calcPoids();
    }

    public double calcPoids() {
        double poids = 0;
        for (int materielId : listMaterielMedical) {
            MaterielMedical materiel = Application.getInstance().getMaterielById(materielId);
            poids += materiel.getPoids();
        }
        poids += poidsColis(this.type);
        return poids;
    }

    public double poidsColis(String type) {
        switch (type) {
            case "PAL":
                return 30; // Poids arbitraire a changer en fonction de la taille du colis et des valeurs
                           // rééels
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

    public double getPoids() {
        return poids;
    }

    public double[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(String type) {
        double[] dimensions = new double[3];
        switch (type) {
            case "PAL":
                dimensions[0] = 1.2; // Dimensions arbitraires a changer en fonction de la taille du colis et des
                                     // valeurs rééels
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

    public void setType(String type) {
        this.type = type;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getters
    public ArrayList<Integer> getListMaterielMedical() {
        return listMaterielMedical;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public MaterielMedical getMaterielById(int id) {
        for (int idMateriel : listMaterielMedical) {
            MaterielMedical materiel = Application.getInstance().getMaterielById(idMateriel);
            if (materiel.getId() == id) {
                return materiel;
            }
        }
        return null;
    }

    public void addMateriel(int materiel) {
        listMaterielMedical.add(materiel);
    }

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

    public void addEquipement(String nom, int quantiteEnStock, String description, String fournisseur,
            Date dateExpiration, int ColiId, double poids) {
        Equipement eq = new Equipement(nom, quantiteEnStock, description, fournisseur, null, null, null, ColiId, poids);
        int idEq = eq.getId();
        addMateriel(idEq);
    }

    public void addMedicament(String nom, int quantiteEnStock, String description, String fournisseur,
            Date dateExpiration, int ColiId, double poids) {
        Medicament md = new Medicament(nom, quantiteEnStock, description, fournisseur, dateExpiration, null, null,
                ColiId, poids);
        int idMd = md.getId();
        addMateriel(idMd);
    }

}