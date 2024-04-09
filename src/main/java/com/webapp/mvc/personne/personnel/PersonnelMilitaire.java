package com.webapp.mvc.personne.personnel;

public class PersonnelMilitaire extends Personnel {

    private String rang;
    


    public PersonnelMilitaire(String name, String titre, String affectation) {
        super(name, titre, affectation, "Militaire");
        
        RangPersonnel rg = new RangPersonnel();
        this.rang = rg.getAbbreviation(titre);
        
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
