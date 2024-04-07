package com.webapp.mvc.model.stock;

import com.webapp.mvc.model.medical.MaterielMedical;
import java.util.Date;


public class Commande {
    private int id;
    private Date dateCommande;
    private String etat;
    private MaterielMedical[] articles;

    public void ajouterArticle(MaterielMedical article) {
        // TODO: Implement ajouterArticle method
    }

    public void retirerArticle(MaterielMedical article) {
        // TODO: Implement retirerArticle method
    }

    public void validerCommande() {
        // TODO: Implement validerCommande method
    }

    public void annulerCommande() {
        // TODO: Implement annulerCommande method
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public MaterielMedical[] getArticles() {
        return articles;
    }

    public void setArticles(MaterielMedical[] articles) {
        this.articles = articles;
    }
}
