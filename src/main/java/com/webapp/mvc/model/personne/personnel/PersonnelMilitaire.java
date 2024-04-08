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
        html.append("<td departement=\"").append(this.getRang()).append("\">");
        html.append(this.getRang());
        html.append("</td>");
        html.append("</tr>");
        return html.toString();
    }
    @Override
    public void effectuerTache() {
    }

}
