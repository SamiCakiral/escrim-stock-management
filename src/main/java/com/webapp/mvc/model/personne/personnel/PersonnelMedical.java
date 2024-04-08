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
        html.append("<td departement=\"").append(this.getSpecialite()).append("\">");
        html.append(this.getSpecialite());
        html.append("</td>");
        html.append("</tr>");
        return html.toString();
    }
    @Override
    public void effectuerTache() {
    }

}
