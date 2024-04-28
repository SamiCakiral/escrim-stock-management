package com.webapp.mvc.personne.personnel;
import java.awt.Image;



/**
 * Cette classe abstraite représente le personnel d'une organisation.
 * Elle contient des informations sur l'identité, l'affectation et le métier du personnel.
 * Elle fournit également des méthodes pour effectuer des tâches, affecter le personnel à une affectation,
 * vérifier le planning, obtenir des informations sur le personnel et générer une ligne de tableau HTML.
 *
 * @author CS
 */
public abstract class Personnel {
    private static int idCounter = 0;
    private int id;
    private String last_name;
    private String first_name;
    private String affectation;
    private String metier;

    private Image photo;
    
    /**
     * Constructeur de la classe Personnel.
     *
     * @param last_name   Le nom de famille du personnel.
     * @param first_name  Le prénom du personnel.
     * @param affectation L'affectation du personnel.
     * @param metier      Le métier du personnel.
     */
    public Personnel(String last_name, String first_name, String affectation, String metier) {
        this.id = idCounter++;
        this.last_name = last_name;
        this.first_name = first_name;
        this.affectation = affectation;
        this.metier = metier;
    }
    /**
     * Méthode abstraite pour effectuer une tâche spécifique.
     */
    public abstract void effectuerTache();

    /**
     * Affecte le personnel à une affectation spécifique.
     *
     * @param affectation L'affectation à attribuer au personnel.
     */
    public void affecter(String affectation) {
        this.affectation = affectation;
    }

    @Override
    public String toString() {
        return "Personnel [id=" + id + ", last_name=" + last_name + ", first_name=" + first_name + ", affectation="
                + affectation + ", metier=" + metier + "]";
    }

    /**
     * Vérifie le planning du personnel.
     *
     * @return Une chaîne de caractères représentant le planning du personnel.
     */
    public String verifierPlanning() {
        return "";
    }

    public String getLastName() {
        return last_name;
    }
    public String getFirstName() {
        return first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Obtient le nom complet du personnel.
     *
     * @return Le nom complet du personnel.
     */
    public String getNom() {
        return last_name + " " + first_name;
    }

    /**
     * Obtient la photo du personnel.
     *
     * @return La photo du personnel.
     */
    public Image getPhoto() {
        return photo;
    }

    /**
     * Définit la photo du personnel.
     *
     * @param photo La photo à attribuer au personnel.
     */
    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    /**
     * Obtient l'identifiant du personnel.
     *
     * @return L'identifiant du personnel.
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant du personnel.
     *
     * @param id L'identifiant à attribuer au personnel.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient le nom de famille du personnel.
     *
     * @return Le nom de famille du personnel.
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Définit le nom de famille du personnel.
     *
     * @param last_name Le nom de famille à attribuer au personnel.
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Obtient le prénom du personnel.
     *
     * @return Le prénom du personnel.
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Définit le prénom du personnel.
     *
     * @param first_name Le prénom à attribuer au personnel.
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Obtient l'affectation du personnel.
     *
     * @return L'affectation du personnel.
     */
    public String getAffectation() {
        return affectation;
    }

    /**
     * Définit l'affectation du personnel.
     *
     * @param affectation L'affectation à attribuer au personnel.
     */
    public void setAffectation(String affectation) {
        this.affectation = affectation;
    }

    /**
     * Définit le métier du personnel.
     *
     * @param metier Le métier à attribuer au personnel.
     */
    public void setMetier(String metier) {
        this.metier = metier;
    }

    /**
     * Obtient le métier du personnel.
     *
     * @return Le métier du personnel.
     */
    public String getMetier() {
        return metier;
    }

    /**
     * Génère une ligne de tableau HTML représentant le personnel.
     *
     * @return Une chaîne de caractères représentant une ligne de tableau HTML.
     */
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
