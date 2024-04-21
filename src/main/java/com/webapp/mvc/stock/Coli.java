package com.webapp.mvc.stock;

import java.util.ArrayList;
import com.webapp.mvc.materiel.MaterielMedical;

import java.util.Date;


import com.webapp.mvc.materiel.Equipement;

import com.webapp.mvc.materiel.Medicament;

public class Coli {
    private ArrayList<MaterielMedical> listMaterielMedical;
    private int id;
    private static int idCounter = 0;
    private String nom;

    public Coli(String nom) {
        listMaterielMedical = new ArrayList<>();
        this.id = idCounter++;
        this.nom = nom;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getters
    public ArrayList<MaterielMedical> getListMaterielMedical() {
        return listMaterielMedical;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public MaterielMedical getMaterielById(int id) {
        for (MaterielMedical materiel : listMaterielMedical) {
            if (materiel.getId() == id) {
                return materiel;
            }
        }
        return null;
    }

    public void addMateriel(MaterielMedical materiel) {
        listMaterielMedical.add(materiel);
    }

    public void removeMateriel(int id) {
        MaterielMedical materiel = getMaterielById(id);
        if (materiel != null) {
            listMaterielMedical.remove(materiel);
        }
    }
    public void addEquipement(String nom, int quantiteEnStock, String description, String fournisseur, Date dateExpiration, String Coli){
        Equipement eq = new Equipement(nom, quantiteEnStock, description, fournisseur, null, null, null, Coli);
        addMateriel(eq);
    }    

    public void addMedicament(String nom, int quantiteEnStock, String description, String fournisseur, Date dateExpiration, String Coli){
        Medicament md = new Medicament(nom, quantiteEnStock, description, fournisseur, dateExpiration, null, null, Coli);
        addMateriel(md);
    }


}