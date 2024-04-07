package com.webapp.mvc.model.personne.personnel;

public class PersonnelMilitaire extends Personnel {
    
    private String rang;

    public PersonnelMilitaire(String name, String titre, String departement, String rang) {
        super(name, titre, departement);
        this.rang = rang;
    }

    public void assignerRang(String rang) {
        this.rang = rang;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }


    @Override
    public void effectuerTache() {
    }

}
