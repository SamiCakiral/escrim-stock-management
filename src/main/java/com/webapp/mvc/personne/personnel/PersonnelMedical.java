package com.webapp.mvc.personne.personnel;

public class PersonnelMedical extends Personnel {
    
    private String specialite = "";


    public PersonnelMedical(String last_name, String first_name, String affectation) {
        super(last_name, first_name, affectation, "Médecin");
        
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
