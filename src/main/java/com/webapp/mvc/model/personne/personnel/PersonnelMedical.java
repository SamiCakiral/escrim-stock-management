package com.webapp.mvc.model.personne.personnel;

public class PersonnelMedical extends Personnel {
    
    private String specialite;

    public PersonnelMedical(int id, String name, String titre, String departement, String specialite) {
        super(id, name, titre, departement);
        this.specialite = specialite;
    }

    public void assignerSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
