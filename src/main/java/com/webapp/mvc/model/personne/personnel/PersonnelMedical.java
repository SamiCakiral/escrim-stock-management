package com.webapp.mvc.model.personne.personnel;

public class PersonnelMedical extends Personnel {
    
    private String specialite;

    public PersonnelMedical(String name, String titre, String departement, String specialite) {
        super(name, titre, departement);
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


    @Override
    public void effectuerTache() {
    }

}
