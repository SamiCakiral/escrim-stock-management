package com.webapp.mvc.personne.personnel;
import java.awt.Image;
public abstract class Personnel {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String titre;
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

    public Personnel(String name, String titre, String affectation, String metier) {
        this.id = idCounter++;
        this.name = name;
        this.titre = titre;
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
        html.append("<td name=\"").append(this.getName()).append("\">");
        html.append(this.getName());
        html.append("</td>");
        html.append("<td titre=\"").append(this.getTitre()).append("\">");
        html.append(this.getTitre());
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
