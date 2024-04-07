package com.webapp.mvc.model.personne.personnel;

public abstract class Personnel {
    private int id;
    private String name;
    private String titre;
    private String departement;
    
    public void assignerDepartement(String departement) {
        this.departement = departement;
    }
    
    public String verifierPlanning() {
        return "";
    }

    public Personnel(int id, String name, String titre, String departement) {
        this.id = id;
        this.name = name;
        this.titre = titre;
        this.departement = departement;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

}
