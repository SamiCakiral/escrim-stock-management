package com.webapp.mvc.personne.personnel;
import java.awt.Image;
public abstract class Personnel {
    private static int idCounter = 0;
    private int id;
    private String last_name;
    private String first_name;
    private String affectation;
    private String metier;

    private Image photo;


    public abstract void effectuerTache();
    

    public void affecter(String affectation) {
        this.affectation = affectation;
    }

    public String verifierPlanning() {
        return "";
    }

    public Personnel(String last_name, String first_name, String affectation, String metier) {
        this.id = idCounter++;
        this.last_name = last_name;
        this.first_name = first_name;
        this.affectation = affectation;
        this.metier = metier;

    }

    public Image getPhoto() {
        return photo;
    }
    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getAffectation() {
        return affectation;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }
    
    public String getMetier() {
        return metier;
    }
    

    public String toHtmlTableRow() {
        StringBuilder html = new StringBuilder();

        html.append("<td id=\"").append(this.getId()).append("\"");
        html.append(" class=\"").append(this.getClass().getSimpleName()).append("\">");
        html.append(this.getId());
        html.append("</td>");
        html.append("<td name=\"").append(this.getLast_name()).append("\">");
        html.append(this.getLast_name());
        html.append("</td>");
        html.append("<td titre=\"").append(this.getFirst_name()).append("\">");
        html.append(this.getFirst_name());
        html.append("</td>");
        html.append("<td metier=\"").append(this.getMetier()).append("\">");
        html.append(this.getMetier());
        html.append("</td>");
        html.append("<td departement=\"").append(this.getAffectation()).append("\">");
        html.append(this.getAffectation());
        html.append("</td>");

        return html.toString();
    }

}
