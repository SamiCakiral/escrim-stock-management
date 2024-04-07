package com.webapp.mvc.model.personne.personnel;

public abstract class Personnel {
    private static int idCounter = 0;
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

    public Personnel( String name, String titre, String departement) {
        this.id = idCounter++;
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

    public abstract void effectuerTache();


    public String toHtmlTableRow() {
        StringBuilder html = new StringBuilder();
        html.append("<tr>");
        html.append("<td id=\"").append(this.getId()).append("\"");
        html.append(" class=\"").append(this.getClass().getSimpleName()).append("\">");
        html.append(this.getId());
        html.append("</td>");
        html.append("<td name=\"").append(this.getName()).append("\">");
        html.append(this.getName());
        html.append("</td>");
        html.append("<td titre=\"").append(this.getTitre()).append("\">");
        html.append(this.getTitre());
        html.append("</td>");
        html.append("<td departement=\"").append(this.getDepartement()).append("\">");
        html.append(this.getDepartement());
        html.append("</td>");
        html.append("</tr>");
        return html.toString();
    }
    
}
