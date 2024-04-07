package com.webapp.mvc.model.personne.personnel;

import com.webapp.mvc.model.materiel.MaterielMedical;

public class EquipeSauvetage extends Personnel {
    private String typeIntervention;
    private Personnel personnelDeploye[];
    private MaterielMedical materielDeploye[];
    private boolean interventionEnCours;


    public EquipeSauvetage( String name, String titre, String departement, String typeIntervention,
            Personnel personnelDeploye[], MaterielMedical materielDeploye[]) {
        super( name, titre, departement);
        this.typeIntervention = typeIntervention;
        this.personnelDeploye = personnelDeploye;
        this.materielDeploye = materielDeploye;
        this.interventionEnCours = false;
    }

    public String getTypeIntervention() {
        return typeIntervention;
    }

    public void setTypeIntervention(String typeIntervention) {
        this.typeIntervention = typeIntervention;
    }

    public Personnel[] getPersonnelDeploye() {
        return personnelDeploye;
    }

    public void setPersonnelDeploye(Personnel[] personnelDeploye) {
        this.personnelDeploye = personnelDeploye;
    }

    public MaterielMedical[] getMaterielDeploye() {
        return materielDeploye;
    }

    public void setMaterielDeploye(MaterielMedical[] materielDeploye) {
        this.materielDeploye = materielDeploye;
    }

    public void deployerEquipe() {
        System.out.println("Equipe deployee");
    }

    public void verifierMateriel() {
        System.out.println("Materiel verifie");
    }

    public void verifierPersonnel() {
        System.out.println("Personnel verifie");
    }

    public void intervenir() {
        if (interventionEnCours) {
            System.out.println("Intervention en cours");
        } else {
            interventionEnCours = true;
            System.out.println("Intervention en cours");
        }
    }

    public void retourBase() {
        System.out.println("Retour a la base");
    }

    public void rapportIntervention() {
        System.out.println("Rapport d'intervention");
    }

    public void rapportMateriel() {
        System.out.println("Rapport materiel");
    }

    @Override
    public void effectuerTache() {
    }

}
